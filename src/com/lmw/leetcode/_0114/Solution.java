package com.lmw.leetcode._0114;

/**
 * https://zhuanlan.zhihu.com/p/273612723
 *
 * @since 2021-03-08
 */
public class Solution {

    static class Node {
        public int val;

        public Node left;

        public Node right;

        public Node next;

        public Node() {
        }

        public Node(final int _val) {
            val = _val;
        }

        public Node(final int _val, final Node _left, final Node _right, final Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 主函数
    public Node connect(final Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    // 辅助函数
    public void connectTwoNode(final Node node1, final Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }
}
