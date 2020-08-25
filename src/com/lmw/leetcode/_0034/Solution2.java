package com.lmw.leetcode._0034;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: lmw
 * Date: 2020/8/26 7:44
 * Description: 思路：用二分查找，找到第一次出现target的位置，然后往下遍历找到第二次出现target的位置
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0 || nums[0] > target) {
            return ans;
        }
        int low = 0, high = nums.length - 1;
        // 用二分查找，找到第一次出现target的位置
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || (nums[mid] == target && nums[mid - 1] < target)) {
                    ans[0] = mid;
                    break;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        if (ans[0] != -1 && nums[ans[0]] == target) {
            if (ans[0] == nums.length - 1) {
                ans[1] = ans[0];
            } else {
                // 往下遍历找到第二次出现target 的位置
                for (int i = ans[0] + 1; i < nums.length; ++i) {
                    if (nums[i] != target) {
                        ans[1] = i - 1;
                        break;
                    }
                    if (i == nums.length - 1 && nums[i] == target) {
                        ans[1] = i;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        int[] ints = {-1, 0, 3, 5, 9, 12, 3};
        System.out.println(Arrays.toString(solution.searchRange(ints, 3)));
    }
}