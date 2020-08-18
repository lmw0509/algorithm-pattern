package com.lmw.leetcode._0098;


import com.lmw.leetcode.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路：中序遍历，如果中序遍历得到的节点的值小于等于前一个 preVal，说明不是二叉搜索树
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double preVal = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.offerFirst(root);
                root = root.left;
            }
            root = stack.pollFirst();
            // 如果中序遍历得到的节点的值小于等于前一个 preVal，说明不是二叉搜索树
            if (root.val <= preVal) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[2,1,3]"));
        System.out.println(solution.isValidBST(TreeNode.createTestData("[2,1,3]")));

        TreeNode.print(TreeNode.createTestData("[5,1,4,null,null,3,6]"));
        System.out.println(solution.isValidBST(TreeNode.createTestData("[5,1,4,null,null,3,6]")));
    }
}