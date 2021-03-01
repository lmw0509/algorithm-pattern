package com.lmw.leetcode._0322;

/**
 * 暴力解法：
 * 根据伪码，我们加上 base case 即可得到最终的答案。
 * 显然目标金额为 0 时，所需硬币数量为 0；当目标金额小于 0 时，无解，返回 -1：
 *
 * @since 2021-02-27
 */
public class Solution2 {

    public int coinChange(final int[] coins, final int amount) {
        return dp(coins, amount);
    }

    // 定义：要凑出金额 n，至少要 dp(n) 个硬币
    public int dp(final int[] coins, final int amount) {
        // 确定 base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        // 求最小值，所以初始化为正无穷
        int res = Integer.MAX_VALUE;
        // 做选择，选择需要硬币最少的那个结果
        for (final int coin : coins) {
            // 子问题
            final int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                // 子问题无解，跳过
                continue;
            }
            res = Math.min(res, 1 + dp(coins, amount - coin));
        }
        return res;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        System.out.println(solution.coinChange(new int[] {1, 2, 5}, 11));
    }
}
