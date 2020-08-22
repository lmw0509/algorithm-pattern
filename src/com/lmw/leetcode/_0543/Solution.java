package com.lmw.leetcode._0543;


import com.lmw.leetcode.structure.TreeNode;

class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (l + r > max) max = l + r;
        return Math.max(l, r) + 1;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[3,9,20,null,null,15,7]"));
        System.out.println(solution.diameterOfBinaryTree(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}
