package com.lmw.leetcode._0088;


import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0)
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        while (n >= 0)
            nums1[p--] = nums2[n--];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] intA = new int[]{1, 2, 3, 0, 0, 0};
        int[] intB = new int[]{2, 5, 6};
        solution.merge(intA, 3, intB, 3);
        System.out.println(Arrays.toString(intA));
    }
}
