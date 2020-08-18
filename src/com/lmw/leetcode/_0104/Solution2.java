package com.lmw.leetcode._0104;


import com.lmw.leetcode.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null)
                    deque.addLast(cur.left);
                if (cur.right != null)
                    deque.addLast(cur.right);
            }
            count++;
        }
        return count;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        TreeNode.print(TreeNode.createTestData("[3,9,20,null,null,15,7]"));
        System.out.println(solution.maxDepth(TreeNode.createTestData("[3,9,20,null,null,15,7]")));
    }
}