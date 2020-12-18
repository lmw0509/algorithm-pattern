package com.lmw.leetcode._0217;

import java.util.Arrays;

/**
 * 去重
 *
 * @since 2020-12-18
 */
public class Solution3 {
    public boolean containsDuplicate(final int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
