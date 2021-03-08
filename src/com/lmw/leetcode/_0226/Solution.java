package com.lmw.leetcode._0226;

import com.lmw.leetcode.structure.TreeNode;

/**
 * https://zhuanlan.zhihu.com/p/273612723
 *
 * @since 2021-03-08
 */
public class Solution {
    // 将整棵树的节点翻转
    public TreeNode invertTree(final TreeNode root) {
        // base case
        if (root == null) {
            return null;
        }

        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        final TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[4,2,7,1,3,6,9]"));
        TreeNode.print(solution.invertTree(TreeNode.createTestData("[4,2,7,1,3,6,9]")));
    }

}
