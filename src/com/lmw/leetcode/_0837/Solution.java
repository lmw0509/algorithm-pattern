package com.lmw.leetcode._0837;


/**
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * <p>
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * <p>
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 */
class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        // 停止时候最大值K+W
        double[] dp = new double[K + W];
        // 对于大于K小于N的值，必须停止抓牌，小于N的概率是1
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        // K-1时候还能抓一次，计算其抓完之后小于N的概率
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        // 计算0到K-2之间的概率，利用状态转移方程计算
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ins = {2, 3, 5, 1, 3};
        System.out.println(solution.new21Game(6, 1, 10));
    }
}
