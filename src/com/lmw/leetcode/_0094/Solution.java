package com.lmw.leetcode._0094;


import java.util.ArrayList;
import java.util.List;

import com.lmw.leetcode.structure.TreeNode;

class Solution {

    public List<Integer> inorderTraversal(final TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(final TreeNode root, final List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]"));
        System.out.println(solution.inorderTraversal(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]")));
    }
}
