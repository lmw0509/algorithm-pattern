package com.lmw.leetcode._0270;


import com.lmw.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int closestValue(TreeNode root, double target) {
        List<Integer> nums = new ArrayList();
        inorder(root, nums);
        return Collections.min(nums, (o1, o2) -> Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1);
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[4,2,7,1,3]"));
        System.out.println(solution.closestValue(TreeNode.createTestData("[4,2,7,1,3]"), 2.75));
    }
}
