package com.lmw.leetcode._0094;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lmw.leetcode.structure.TreeNode;

class Solution2 {

    public List<Integer> inorderTraversal(final TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]"));
        System.out.println(solution.inorderTraversal(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]")));
    }
}
