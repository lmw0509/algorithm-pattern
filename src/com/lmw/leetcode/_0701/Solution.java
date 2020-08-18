package com.lmw.leetcode._0701;


import com.lmw.leetcode.structure.TreeNode;


/**
 * 思路：DFS查找插入位置,找到最后一个叶子节点满足插入条件即可
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[4,2,7,1,3]"));
        System.out.println(solution.insertIntoBST(TreeNode.createTestData("[4,2,7,1,3]"), 5));
    }
}
