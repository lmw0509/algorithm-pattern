package com.lmw.leetcode._0010;

import java.util.HashMap;
import java.util.Map;

/**
 * https://zhuanlan.zhihu.com/p/78514888
 *
 * @since 2021-03-01
 */
public class Solution {
    Map<String, Boolean> memo = new HashMap<>();

    public boolean isMatch(final String s, final String p) {
        // 指针 i，j 从索引 0 开始移动
        return dp(s, 0, p, 0);
    }

    // 计算 p[j] 是否匹配 s[i]
    public boolean dp(final String s, final int i, final String p, int j) {
        final int m = s.length();
        final int n = p.length();
        // base case
        // 模式串 p 已经被匹配完了，那么应该看看文本串 s 匹配到哪里了，如果 s 也恰好被匹配完，则说明匹配成功
        if (j == n) {
            return i == m;
        }
        // s 已经全部被匹配了，此时并不能根据 j 是否等于 p.size() 来判断是否完成匹配，只要 p[j..] 能够匹配空串，就可以算完成匹配。
        // 比如说 s = "a", p = "ab*c*"，当 i 走到 s 末尾的时候，j 并没有走到 p 的末尾，但是 p 依然可以匹配 s。
        if (i == m) {
            // 如果能匹配空串，一定是字符和 * 成对儿出现
            if ((n - j) % 2 == 1) {
                return false;
            }
            // 检查是否为 x*y*z* 这种形式
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        // 记录状态 (i, j)，消除重叠子问题
        final String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        final boolean res;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 有 * 通配符，可以匹配 0 次/多次
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                // 无 * 通配符，老老实实匹配 1 次
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 不匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 有 * 通配符，只能匹配 0 次
                res = dp(s, i, p, j + 2);
            } else {
                // 无 * 通配符，匹配无法进行下去了
                res = false;
            }
        }
        // 将当前结果记入备忘录
        memo.putIfAbsent(key, res);

        return res;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.isMatch("aab", "a*b"));
    }
}
