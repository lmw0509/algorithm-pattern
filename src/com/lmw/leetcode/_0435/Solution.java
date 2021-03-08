package com.lmw.leetcode._0435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 思路：https://zhuanlan.zhihu.com/p/91254104
 */
class Solution {

    // 最多不会重叠区间个数
    public int intervalSchedule(final int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(final int[] a, final int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (final int[] interval : intvs) {
            final int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

    // 最少需要去掉的区间数
    public int eraseOverlapIntervals(final int[][] intervals) {
        final int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
