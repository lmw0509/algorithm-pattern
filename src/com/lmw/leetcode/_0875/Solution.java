package com.lmw.leetcode._0875;

/**
 * https://zhuanlan.zhihu.com/p/90175154
 *
 * @since 2021-03-08
 */
class Solution {

    public int minEatingSpeed(final int[] piles, final int h) {
        // 套用搜索左侧边界的算法框架
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            // 防止溢出
            final int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 时间复杂度 O(N)
    boolean canFinish(final int[] piles, final int speed, final int H) {
        int time = 0;
        for (final int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    int timeOf(final int n, final int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    int getMax(final int[] piles) {
        int max = 0;
        for (final int n : piles)
            max = Math.max(n, max);
        return max;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final int[] piles = {3, 6, 7, 11};
        System.out.println(solution.minEatingSpeed(piles, 8));
    }
}
