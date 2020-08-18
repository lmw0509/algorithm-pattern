package com.lmw.leetcode._0124;


import com.lmw.leetcode.structure.TreeNode;


class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int curMaxSum = node.val + leftGain + rightGain;
        // 更新最大路径和
        maxSum = Math.max(maxSum, curMaxSum);
        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[-10,9,20,null,null,15,7]"));
        System.out.println(solution.maxPathSum(TreeNode.createTestData("[-10,9,20,null,null,15,7]")));
    }
}