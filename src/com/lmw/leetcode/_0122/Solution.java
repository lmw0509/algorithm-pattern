package com.lmw.leetcode._0122;


class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ins = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(ins));
    }
}