
package com.lmw.leetcode._0217;

import java.util.Arrays;

/**
 * 排序
 *
 * @since 2020-12-18
 */
public class Solution {
    public boolean containsDuplicate(final int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
