package com.lmw.leetcode._0322;

/**
 * 伪码框架:
 * 比如你想求 amount = 11 时的最少硬币数（原问题），
 * 如果你知道凑出 amount = 10 的最少硬币数（子问题），
 * 你只需要把子问题的答案加一（再选一枚面值为 1 的硬币）就是原问题的答案
 *
 * @since 2021-02-27
 */
public class Solution1 {
    public int coinChange(final int[] coins, final int amount) {
        return dp(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp(n) 个硬币
    public int dp(final int[] coins, final int amount) {
        int res = Integer.MAX_VALUE;
        // 做选择，选择需要硬币最少的那个结果
        for (final int coin : coins) {
            res = Math.min(res, 1 + dp(coins, amount - coin));
        }
        return res;
    }
}
