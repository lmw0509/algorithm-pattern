package com.lmw.leetcode._0122;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 *
 * @since 2020-12-18
 */
class Solution2 {
    public int maxProfit(final int[] prices) {
        final int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        final int[] ins = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(ins));
    }
}
