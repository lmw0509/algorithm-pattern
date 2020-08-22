package com.lmw.leetcode._0542;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dist = new int[row][col];
        int MAX_TEMP = Integer.MAX_VALUE / 2;
        // 如果 (i, j) 的元素为 0，那么距离为 0，否则设置成一个很大的数
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = MAX_TEMP;
                }
            }
        }
        // 水平向左移动 和 竖直向上移动
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 水平向右移动 和 竖直向下移动
        for (int i = row - 1; i >= 0; --i) {
            for (int j = col - 1; j >= 0; --j) {
                if (i + 1 < row) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < col) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }
}
