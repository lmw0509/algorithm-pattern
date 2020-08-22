package com.lmw.leetcode._0084;


class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;
        int result = 0;

        for (int i = 0; i < n; ++i) {
            int curMin = heights[i];

            for (int j = i; j < n; ++j) {
                curMin = Math.min(curMin, heights[j]);
                result = Math.max(result, (j - i + 1) * curMin);
            }
        }

        return result;
    }
}
