package com.lmw.leetcode._0300;

import java.util.Arrays;

/**
 * 动态规划
 *
 * @since 2021-03-03
 */
public class Solution {
    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    // nums[5] = 7，既然是递增子序列，我们只要找到前面那些结尾比 7 小的子序列，
    // 然后把 7 接到最后，就可以形成一个新的递增子序列，而且这个新的子序列长度加一
    // 显然，可能形成很多种新的子序列，但是我们只选择最长的那一个，把最长子序列的长度作为 dp[5] 的值即可
    // for (int j = 0; j < 5; j++) {
    // if (nums[j] < 7) {
    // dp[5] = Math.max(dp[5], dp[j] + 1);
    // }
    // }
    public int lengthOfLIS(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        final int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            // dp[i]
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (final int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
