package com.lmw.leetcode._0084;


import java.util.Stack;

class Solution2 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int result = 0;

        for (int i = 0; i <= n; ++i) {
            // curElement 表示当前元素的值，用 -1 表示数组的结束
            int curElement = (i == n) ? -1 : heights[i];

            // 元素的出栈操作，表明当前栈顶元素找到了右边界
            // 加上栈内存放的元素是单调递增的，因此左边界也找到了
            // while 里面针对栈顶元素这个高度的矩形计算面积即可
            while (!stack.isEmpty() && heights[stack.peek()] >= curElement) {
                int high = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                result = Math.max(result, high * width);
            }

            stack.push(i);
        }
        return result;
    }
}
