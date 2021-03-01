package com.lmw.leetcode._0322;

import java.util.HashMap;
import java.util.Map;

/**
 * 带备忘录的递归，消除子问题：
 * 「备忘录」大大减小了子问题数目，完全消除了子问题的冗余，
 * 所以子问题总数不会超过金额数 n，即子问题数目为 O(n)。
 * 处理一个子问题的时间不变，仍是 O(k)，所以总的时间复杂度是 O(kn)。
 *
 * @since 2021-02-27
 */
public class Solution3 {

    // 定义备忘录
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(final int[] coins, final int amount) {
        return dp(coins, amount);
    }

    // 目标金额amount作为变量
    // 定义：要凑出金额 amount，至少要 dp(amount) 个硬币
    public int dp(final int[] coins, final int amount) {
        // 查询备忘录，避免重复计算
        if (memo.get(amount) != null) {
            return memo.get(amount);
        }

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

        // 记入备忘录
        if (res != Integer.MAX_VALUE) {
            memo.putIfAbsent(amount, res);
        }

        return res;
    }

    public static void main(final String[] args) {
        final Solution3 solution = new Solution3();
        System.out.println(solution.coinChange(new int[] {1, 2, 5}, 11));
    }
}
