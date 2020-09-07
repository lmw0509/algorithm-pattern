package com.lmw.leetcode._0137;


class Solution {
    public int singleNumber(final int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for (final int num : nums) {
            // 只出现一次的数按照下面的规则运算后，seenOnce就等于该数。出现三次的数运算后，seenOnce 和 seenTwice都为0
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
