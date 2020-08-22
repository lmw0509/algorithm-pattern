package com.lmw.sword._32I;

import com.lmw.leetcode.structure.TreeNode;

import java.util.*;

class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.val);
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[3,9,20,null,null,15,7]"));
        System.out.println(Arrays.toString(solution.levelOrder(TreeNode.createTestData("[3,9,20,null,null,15,7]"))));
    }
}
