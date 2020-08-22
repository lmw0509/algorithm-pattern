package com.lmw.leetcode._0108;


import com.lmw.leetcode.structure.TreeNode;


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        int[] ints = new int[]{-10, -3, 0, 5, 9};
        TreeNode.print(solution.sortedArrayToBST(ints));
    }
}