package com.lmw.leetcode._0704;


/**
 * 二分法，模板#1
 */
class Solution {
    public int search(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        int[] ints = {-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(ints, 9));
    }
}
