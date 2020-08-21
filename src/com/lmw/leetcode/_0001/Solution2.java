package com.lmw.leetcode._0001;


import java.util.Arrays;
import java.util.HashMap;

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
    }
}
