package com.lmw.leetcode._0072;

/**
 * https://zhuanlan.zhihu.com/p/80682302
 *
 * @since 2021-03-03
 */
public class Solution {

    public int minDistance(final String s1, final String s2) {
        final int m = s1.length();
        final int n = s2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // dp数组
        final int[][] dp = new int[m + 1][n + 1];

        // base case
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 恰好相等，跳过
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp(i, j - 1) + 1, # 插入
                    // dp(i - 1, j) + 1, # 删除
                    // dp(i - 1, j - 1) + 1 # 替换
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }

        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    private int min(final int a, final int b, final int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.minDistance("intention", "execution"));
    }
}
