package com.lmw.leetcode._0014;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        for (int j = 0; j < minLen; ++j)
            for (int i = 1; i < len; ++i)
                if (strs[0].charAt(j) != strs[i].charAt(j))
                    return strs[0].substring(0, j);
        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strArr = new String[] {"flower", "flow", "flight"};
        System.out.println(solution.longestCommonPrefix(strArr));
    }
}
