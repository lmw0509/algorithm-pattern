package com.lmw.leetcode._0116;

import com.lmw.leetcode.structure.TreeNode;

/**
 * https://zhuanlan.zhihu.com/p/273612723
 *
 * @since 2021-03-08
 */
public class Solution {
    // 定义：将以 root 为根的树拉平为链表
    public void flatten(final TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        final TreeNode left = root.left;
        final TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final TreeNode node = TreeNode.createTestData("[4,2,7,1,3,6,9]");
        TreeNode.print(node);
        solution.flatten(node);
        TreeNode.print(node);
    }
}
