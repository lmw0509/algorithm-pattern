package com.lmw.leetcode._0102;


import com.lmw.leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 思路：BFS
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
 */
class Solution {
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // size记录当前层有多少元素（遍历当前层，再添加下一层）
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]"));
        System.out.println(solution.levelOrder(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]")));
    }
}
