package com.lmw.leetcode._0101;


import com.lmw.leetcode.structure.TreeNode;

import java.util.LinkedList;

class Solution2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        TreeNode left, right;
        while (q.size() > 1) {
            left = q.pop();
            right = q.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        TreeNode.print(TreeNode.createTestData("[1,2,2,3,4,4,3]"));
        System.out.println(solution.isSymmetric(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
    }
}
