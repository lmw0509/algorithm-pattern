package com.lmw.leetcode._0034;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int l = left;
        int r = right;

        //找左边
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left > right || nums[left] != target) {
            return new int[]{-1, -1};
        }

        //找右边
        while (l < r) {
            int mid = (l + r) / 2 + 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        if (left > r) {
            return new int[]{-1, -1};
        } else {
            return new int[]{left, r};
        }
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        int[] ints = {-1, 0, 3, 5, 9, 12, 3};
        System.out.println(Arrays.toString(solution.searchRange(ints, 3)));
    }
}