package com.lmw.leetcode._0136;


/**
 * Created with IntelliJ IDEA.
 * User: lmw
 * Date: 2020/8/31 23:40
 * Description:
 */
public class Solution {
    public int singleNumber(final int[] nums) {
        int result = 0;
        for (final int num : nums) {
            // 两个相同的数做异或操作等于0，0与任何数异或，数值不变。
            result = result ^ num;
        }
        return result;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1,2,3,1,2}));
    }
}
