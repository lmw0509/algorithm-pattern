package com.lmw.leetcode._1011;

/**
 * https://zhuanlan.zhihu.com/p/90175154
 *
 * @since 2021-03-08
 */
class Solution {
    // 寻找左侧边界的二分查找
    int shipWithinDays(final int[] weights, final int d) {
        // 载重可能的最小值
        int left = getMax(weights);
        // 载重可能的最大值 + 1
        int right = getSum(weights) + 1;
        while (left < right) {
            final int mid = left + (right - left) / 2;
            if (canFinish(weights, d, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 如果载重为 cap，是否能在 D 天内运完货物？
    boolean canFinish(final int[] w, final int D, final int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= w[i]) >= 0) {
                i++;
                if (i == w.length)
                    return true;
            }
        }
        return false;
    }

    int getMax(final int[] weights) {
        int max = 0;
        for (final int n : weights)
            max = Math.max(n, max);
        return max;
    }

    int getSum(final int[] weights) {
        int sum = 0;
        for (final int n : weights)
            sum += n;
        return sum;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final int[] weights = {3, 2, 2, 4, 1, 4};
        System.out.println(solution.shipWithinDays(weights, 3));
    }
}
