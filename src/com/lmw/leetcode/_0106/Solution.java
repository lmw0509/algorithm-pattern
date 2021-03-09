package com.lmw.leetcode._0106;

import com.lmw.leetcode.structure.TreeNode;

/**
 * 功能描述
 *
 * @since 2021-03-09
 */
class Solution {

    TreeNode buildTree(final int[] inorder, final int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode build(final int[] inorder, final int inStart, final int inEnd, final int[] postorder,
        final int postStart, final int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        final int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 左子树的节点个数
        final int leftSize = index - inStart;
        final TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final int[] inorder = new int[] {9, 3, 15, 20, 7};
        final int[] postorder = new int[] {9, 15, 7, 20, 3};
        TreeNode.print(solution.buildTree(inorder, postorder));
    }
}
