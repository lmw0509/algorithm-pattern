package com.lmw.leetcode._0026;

/**
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
 *
 * @since 2020-12-18
 */
class Solution2 {
    public int removeDuplicates(final int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        final int[] ints = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(ints));
    }
}
