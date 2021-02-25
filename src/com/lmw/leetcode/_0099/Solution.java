package com.lmw.leetcode._0099;

import com.lmw.leetcode.structure.TreeNode;

/**
 * 思路：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/zhong-xu-bian-li-by-powcai/
 */
class Solution {
    TreeNode firstNode = null;

    TreeNode secondNode = null;

    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(final TreeNode root) {
        in_order(root);
        final int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    private void in_order(final TreeNode root) {
        if (root == null) {
            return;
        }
        in_order(root.left);
        if (firstNode == null && preNode.val > root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val > root.val) {
            secondNode = root;
        }
        preNode = root;
        in_order(root.right);
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[1,3,null,null,2]"));
        final TreeNode treeNode = TreeNode.createTestData("[1,3,null,null,2]");
        solution.recoverTree(treeNode);
        System.out.println(treeNode);
    }
}
