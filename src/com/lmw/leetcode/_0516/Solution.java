package com.lmw.leetcode._0516;

/**
 * https://zhuanlan.zhihu.com/p/100994146
 *
 * @since 2021-03-08
 */
public class Solution {
    public int longestPalindromeSubseq(final String s) {
        final int n = s.length();
        // dp[i][j] 在子串 s[i..j] 中，最长回文子序列的长度
        // dp 数组全部初始化为 0
        final int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                // 它俩一定在最长回文子序列中
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 整个 s 的最长回文子串长度
        return dp[0][n - 1];
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }
}
