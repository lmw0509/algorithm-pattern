package com.lmw.leetcode._0191;


class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            // n & (n - 1)运算，将n的二进制数最后一位1变为0，循环直到n为0
            n = n & (n - 1);
        }
        return sum;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        //00000000000000000000000000001011
        System.out.println(solution.hammingWeight(11));
    }
}


