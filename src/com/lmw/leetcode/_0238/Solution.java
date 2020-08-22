package com.lmw.leetcode._0238;


import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < res.length; i++) {
            // 此时数组存储的是除去当前元素左边的元素乘积
            res[i] = k;
            k = k * nums[i];
        }
        int j = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            // j为该数右边的乘积
            // 此时数组存储的数字变成左边的 * 该数右边的
            res[i] *= j;
            j *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ins = {2, 3, 5, 1, 3};
        System.out.println(Arrays.toString(solution.productExceptSelf(ins)));
    }
}