package com.lmw.leetcode._0028;

class Solution {
    public int strStr(final String haystack, final String needle) {
        final int l1 = haystack.length();
        final int l2 = needle.length();
        if (l1 < l2) {
            return -1;
        }
        for (int i = 0; i < l1 - l2 + 1; i++) {
            for (int j = 0; j < l2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == l2 - 1) {
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
