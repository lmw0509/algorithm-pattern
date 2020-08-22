package com.lmw.leetcode._0101;


import com.lmw.leetcode.structure.TreeNode;


class Solution {

    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[1,2,2,3,4,4,3]"));
        System.out.println(solution.isSymmetric(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
    }
}
