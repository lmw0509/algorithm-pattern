package com.lmw.leetcode._0322;

/**
 * 链接：https://zhuanlan.zhihu.com/p/78220312
 *
 * @since 2021-02-27
 */
public class Solution {
    public int coinChange(final int[] coins, final int amount) {
        if (amount < 1) {
            return 0;
        }
        // 数组大小为 amount + 1，初始值也为 amount + 1
        final int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < amount + 1; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (final int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                // 状态转移方程
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[] {1, 2, 5}, 11));
    }
}
