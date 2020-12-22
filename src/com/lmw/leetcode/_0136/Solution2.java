package com.lmw.leetcode._0136;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: lmw
 * Date: 2020/8/31 23:40
 * Description:
 */
public class Solution2 {
    public int singleNumber(final int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }

        final int n = nums.length;
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        System.out.println(solution.singleNumber(new int[] {1, 3, 3, 1, 2}));
    }
}
