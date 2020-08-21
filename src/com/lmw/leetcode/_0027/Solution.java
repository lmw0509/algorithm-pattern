package com.lmw.leetcode._0027;


class Solution {
    public int removeElement(int[] nums, int val) {
        int tail = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] != val) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(solution.removeElement(ints, 2));
    }
}