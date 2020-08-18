package com.lmw.leetcode._0107;


import com.lmw.leetcode.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new LinkedList();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                sub.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            list.add(0, sub);
        }
        return list;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[3,9,20,null,null,15,7]"));
        System.out.println(solution.levelOrderBottom(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}