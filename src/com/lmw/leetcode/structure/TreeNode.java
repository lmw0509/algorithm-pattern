package com.lmw.leetcode.structure;


import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int x) {
        val = x;
    }

    /**
     * 创建测试数据（将数组转换成二叉树）
     *
     * @param data [XX,XX,null,xx]
     * @return {@link TreeNode}
     */
    public static TreeNode createTestData(final String data) {
        final String[] strList = data.substring(1, data.length() - 1).split(",");

        TreeNode root;
        TreeNode result = null;
        final Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < strList.length; i++) {
            if (i == 0) {
                root = new TreeNode(Integer.parseInt(strList[i]));
                result = root;
                queue.add(root);
            }
            if (!queue.isEmpty()) {
                root = queue.poll();
            } else {
                break;
            }
            if (i + 1 < strList.length && !strList[i + 1].equals("null")) {
                root.left = new TreeNode(Integer.parseInt(strList[i + 1]));
                queue.add(root.left);
            }
            if (i + 2 < strList.length && !strList[i + 2].equals("null")) {
                root.right = new TreeNode(Integer.parseInt(strList[i + 2]));
                queue.add(root.right);
            }
            i++;
        }
        return result;
    }


    private static final String space = "      ";

    /**
     * 竖向打印二叉树
     *
     * @param root 二叉树根节点
     */
    public static void print(final TreeNode root) {
        print(root, 0);
    }

    private static void print(final TreeNode node, final int deep) {
        if (node == null) {
            printSpace(deep);
            System.out.println("#");
            return;
        }
        print(node.right, deep + 1);
        printSpace(deep);
        printNode(node.val);
        print(node.left, deep + 1);
    }

    private static void printSpace(final int count) {
        for (int i = 0; i < count; i++) {
            System.out.printf(space);
        }
    }

    private static void printNode(final int val) {
        final StringBuilder res = new StringBuilder(val + "<");
        final int spaceNum = space.length() - res.length();
        for (int i = 0; i < spaceNum; i++) {
            res.append(" ");
        }
        System.out.println(res);
    }
}
