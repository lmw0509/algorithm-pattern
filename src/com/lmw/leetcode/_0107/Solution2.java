package com.lmw.leetcode._0107;


import com.lmw.leetcode.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helper(list, root, 0);
        return list;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        TreeNode.print(TreeNode.createTestData("[3,9,20,null,null,15,7]"));
        System.out.println(solution.levelOrderBottom(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}