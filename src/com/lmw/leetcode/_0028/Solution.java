package com.lmw.leetcode._0028;


class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) return -1;
        for (int i = 0; ; i++) {
            if (i + l2 > l1) return -1;
            for (int j = 0; ; j++) {
                if (j == l2) return i;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
    }
}