package com.lmw.leetcode._0028;

/**
 * 暴力解法
 *
 * @since 2021-03-04
 */
class Solution {
    public int strStr(final String haystack, final String needle) {
        final int m = haystack.length();
        final int n = needle.length();
        if (m < n) {
            return -1;
        }
        for (int i = 0; i < m - n + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == n - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
    }
}
