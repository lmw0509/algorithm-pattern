package com.lmw.leetcode._0217;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表
 *
 * @since 2020-12-18
 */
public class Solution2 {
    public boolean containsDuplicate(final int[] nums) {
        final Set<Integer> set = new HashSet<Integer>();
        for (final int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
