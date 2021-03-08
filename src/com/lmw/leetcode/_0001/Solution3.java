package com.lmw.leetcode._0001;

import java.util.Arrays;

/**
 * 如果给的数组是无序的,HashMap 或者 HashSet
 * 如果给的数组是有序的,双指针
 *
 * @since 2021-03-08
 */
class Solution3 {
    public int[] twoSum(final int[] nums, final int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            final int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] {left, right};
            } else if (sum < target) {
                left++; // 让 sum 大一点
            } else {
                right--; // 让 sum 小一点
            }
        }
        // 不存在这样两个数
        return new int[] {-1, -1};
    }

    public static void main(final String[] args) {
        final Solution3 solution = new Solution3();
        final int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
    }
}
