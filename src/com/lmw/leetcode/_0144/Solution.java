package com.lmw.leetcode._0144;


import java.util.ArrayList;
import java.util.List;

import com.lmw.leetcode.structure.TreeNode;

class Solution {

    public List<Integer> preorderTraversal(final TreeNode root) {
        if (root == null) return new ArrayList<>();

        final List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    public List<Integer> preorderTraversal(final TreeNode root, final List<Integer> list) {
        list.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left, list);
        }
        if (root.right != null) {
            preorderTraversal(root.right, list);
        }
        return list;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]"));
        System.out.println(solution.preorderTraversal(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]")));
    }
}
