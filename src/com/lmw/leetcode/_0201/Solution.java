package com.lmw.leetcode._0201;


class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n &= n - 1;
        }
        return m & n;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(5, 7));
    }
}

