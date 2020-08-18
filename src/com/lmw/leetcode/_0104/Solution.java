package com.lmw.leetcode._0104;


import com.lmw.leetcode.structure.TreeNode;


class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[3,9,20,null,null,15,7]"));
        System.out.println(solution.maxDepth(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}