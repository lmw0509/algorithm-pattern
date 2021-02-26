package com.lmw.leetcode._0099;

import com.lmw.leetcode.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/zhong-xu-bian-li-by-powcai/
 * 迭代
 */
class Solution2 {

    public void recoverTree(final TreeNode root) {
        final Deque<TreeNode> stack = new LinkedList<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (firstNode == null && pre.val > p.val)
                firstNode = pre;
            if (firstNode != null && pre.val > p.val)
                secondNode = p;
            pre = p;
            p = p.right;
        }
        final int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        TreeNode.print(TreeNode.createTestData("[1,3,null,null,2]"));
        final TreeNode treeNode = TreeNode.createTestData("[1,3,null,null,2]");
        solution.recoverTree(treeNode);
        TreeNode.print(treeNode);
    }
}
