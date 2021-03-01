package com.lmw.leetcode._0322;

/**
 * dp数组的迭代解法
 * 链接：https://zhuanlan.zhihu.com/p/78220312
 *
 * @since 2021-02-27
 */
public class Solution4 {
    public int coinChange(final int[] coins, final int amount) {
        if (amount < 1) {
            return 0;
        }
        // 数组大小为 amount + 1，初始值也为 amount + 1
        // 因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
        final int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        // base case
        dp[0] = 0;
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
        final Solution4 solution4 = new Solution4();
        System.out.println(solution4.coinChange(new int[] {1, 2, 5}, 11));
    }
}
