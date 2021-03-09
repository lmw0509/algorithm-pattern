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
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
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
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                res = dp(s, i, p, j + 2);
            } else {
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
