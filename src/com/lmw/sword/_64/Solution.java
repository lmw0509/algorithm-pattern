package com.lmw.sword._64;


class Solution {
    public int sumNums(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(100));
    }
}
