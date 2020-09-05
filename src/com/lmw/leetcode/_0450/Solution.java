package com.lmw.leetcode._0450;

import com.lmw.leetcode.structure.TreeNode;

/**
 * 思路：官方递归
 */
class Solution {

    public TreeNode deleteNode(TreeNode root, final int key) {
        if (root == null) {
            return null;
        }
        // 要删除的节点在右子树
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else { // 删除当前结点
            // 当前结点是叶子节点，直接删除
            if (root.right == null && root.left == null) {
                root = null;
            } else if (root.right != null) { // 右子树存在，删除后继结点，后继结点移到当前位置
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

    // 找到当前结点的后继结点的值，
    private int successor(TreeNode node) {
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    // 找到当前结点的前驱结点的值，
    private int predecessor(TreeNode node) {
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[5,3,6,2,4,null,7]"));
        TreeNode.print(solution.deleteNode(TreeNode.createTestData("[5,3,6,2,4,null,7]"), 3));
    }
}
