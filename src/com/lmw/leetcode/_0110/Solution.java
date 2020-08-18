package com.lmw.leetcode._0110;


import com.lmw.leetcode.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Solution {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            result = false;
        }
        // 返回的相当于子树的高度
        return 1 + Math.max(leftDepth, rightDepth);

    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[3,9,20,null,null,15,7]"));
        System.out.println(solution.isBalanced(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}