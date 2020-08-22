package com.lmw.leetcode._1431;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * <p>
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue = candies[0];
        for (int val : candies) {
            if (val > maxValue) {
                maxValue = val;
            }
        }
        List<Boolean> hasMaxCandiesList = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxValue) {
                hasMaxCandiesList.add(true);
            } else {
                hasMaxCandiesList.add(false);
            }
        }
        return hasMaxCandiesList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ins = {2, 3, 5, 1, 3};
        System.out.println(solution.kidsWithCandies(ins, 3));
    }
}
