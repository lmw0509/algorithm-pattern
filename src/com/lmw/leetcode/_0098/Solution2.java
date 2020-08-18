package com.lmw.leetcode._0098;


import com.lmw.leetcode.structure.TreeNode;


/**
 * 思路：递归法，判断 左 MAX < 根 < 右 MIN
 */
class Solution2 {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if ((lower != null && val <= lower) || (upper != null && val >= upper)) {
            return false;
        }
        return helper(node.right, val, upper) && helper(node.left, lower, val);
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        TreeNode.print(TreeNode.createTestData("[2,1,3]"));
        System.out.println(solution.isValidBST(TreeNode.createTestData("[2,1,3]")));

        TreeNode.print(TreeNode.createTestData("[5,1,4,null,null,3,6]"));
        System.out.println(solution.isValidBST(TreeNode.createTestData("[5,1,4,null,null,3,6]")));
    }
}
