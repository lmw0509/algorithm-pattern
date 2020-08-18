package com.lmw.leetcode._0144;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.lmw.leetcode.structure.TreeNode;

class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        //非递归前序遍历，需要借助栈
        final Stack<TreeNode> stack = new Stack<>();
        final List<Integer> list = new LinkedList<>();
        //当树为空树时，直接返回一个空list
        if (root == null) {
            return list;
        }
        //第一步是将根节点压入栈中
        stack.push(root);
        //当栈不为空时，出栈的元素插入list尾部。
        //当它的子节点不为空时，将子节点压入栈，一定是先压右子节点再压左子节点
        while (!stack.isEmpty()) {
            //此处的root只是一个变量的复用
            root = stack.pop();
            list.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return list;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        TreeNode.print(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]"));
        System.out.println(solution.preorderTraversal(TreeNode.createTestData("[1,null,2,3,null,4,5,null,6]")));
    }
}
