package com.lmw.leetcode._0560;

/**
 * https://zhuanlan.zhihu.com/p/107778275
 *
 * @since 2021-03-08
 */
public class Solution {
    public int subarraySum(final int[] nums, final int k) {
        final int n = nums.length;
        // 构造前缀和
        final int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];

        int ans = 0;
        // 穷举所有子数组
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                // sum of nums[j..i-1]
                if (sum[i] - sum[j] == k)
                    ans++;

        return ans;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[] {1, 1, 1}, 2));
    }
}
