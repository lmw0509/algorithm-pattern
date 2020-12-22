package com.lmw.leetcode._0136;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lmw
 * Date: 2020/8/31 23:40
 * Description:
 */
public class Solution3 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }

    public static void main(final String[] args) {
        final Solution3 solution = new Solution3();
        System.out.println(solution.singleNumber(new int[] {1, 3, 3, 1, 2}));
    }
}
