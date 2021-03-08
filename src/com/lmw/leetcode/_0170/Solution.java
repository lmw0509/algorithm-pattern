package com.lmw.leetcode._0170;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 设计并实现一个类，使该类需要支持 add 和 find 的操作。
 * add 操作 - 对内部数据结构增加一个数。
 * find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。
 *
 * @since 2021-03-08
 */
public class Solution {

    Set<Integer> sum = new HashSet<>();

    List<Integer> nums = new ArrayList<>();

    public void add(final int number) {
        // 记录所有可能组成的和
        for (final int n : nums) {
            sum.add(n + number);
        }
        nums.add(number);
    }

    public boolean find(final int value) {
        return sum.contains(value);
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        solution.add(1);
        solution.add(3);
        solution.add(5);
        System.out.println(solution.find(4));
        System.out.println(solution.find(7));
    }
}
