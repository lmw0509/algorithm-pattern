package com.lmw.leetcode._0236;

import com.lmw.leetcode.structure.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[3,5,1,6,2,0,8,null,null,7,4]"));
        //  System.out.println(solution.lowestCommonAncestor(TreeNode.createTestData("[3,5,1,6,2,0,8,null,null,7,4]"), 5, 1));
    }
}