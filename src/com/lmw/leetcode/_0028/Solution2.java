package com.lmw.leetcode._0028;

class Solution2 {
    public int strStr(final String haystack, final String needle) {
        final int l1 = haystack.length();
        final int l2 = needle.length();
        for (int start = 0; start < l1 - l2 + 1; ++start) {
            if (haystack.substring(start, start + l2).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        System.out.println(solution.strStr("hello", "lo"));
    }
}
