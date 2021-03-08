package com.lmw.leetcode._0452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 思路：https://zhuanlan.zhihu.com/p/91254104
 */
class Solution {
    // 最多不会重叠区间个数
    public int findMinArrowShots(final int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 按 end 升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(final int[] a, final int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = points[0][1];
        for (final int[] interval : points) {
            final int start = interval[0];
            if (start > x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(solution.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
