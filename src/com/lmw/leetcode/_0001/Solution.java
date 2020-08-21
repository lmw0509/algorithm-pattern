package com.lmw.leetcode._0001;


import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            final Integer value = map.get(nums[i]);
            if (value != null) {
                return new int[]{value, i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(nums, 9)));
    }
}
