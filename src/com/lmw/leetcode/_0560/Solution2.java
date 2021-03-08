package com.lmw.leetcode._0560;

import java.util.HashMap;

/**
 * https://zhuanlan.zhihu.com/p/107778275
 *
 * @since 2021-03-08
 */
public class Solution2 {
    public int subarraySum(final int[] nums, final int k) {
        final int n = nums.length;
        // map：前缀和 -> 该前缀和出现的次数
        final HashMap<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);
        int ans = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0..j]
            final int sum0_j = sum0_i - k;
            // 如果前面有这个前缀和，则直接更新答案
            if (preSum.containsKey(sum0_j))
                ans += preSum.get(sum0_j);
            // 把前缀和 nums[0..i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[] {1, 1, 1}, 2));
    }
}
