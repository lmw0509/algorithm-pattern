package com.lmw.leetcode._0145;


import java.util.LinkedList;
import java.util.List;

import com.lmw.leetcode.structure.TreeNode;

class Solution2 {

    public List<Integer> postorderTraversal(final TreeNode root) {
        final LinkedList<TreeNode> stack = new LinkedList<>();
        final LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            final TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        TreeNode.print(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]"));
        System.out.println(solution.postorderTraversal(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]")));
    }
}
