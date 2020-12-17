package com.lmw.leetcode._0105;

import com.lmw.leetcode.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(final int[] preorder, final int[] inorder, final int preorder_left,
        final int preorder_right, final int inorder_left, final int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        final int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        final int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        final TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        final int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left,
            inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right,
            inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        final int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final int[] preorder = new int[] {3, 9, 20, 15, 7};
        final int[] inorder = new int[] {9, 3, 15, 20, 7};
        TreeNode.print(solution.buildTree(preorder, inorder));
    }
}
