package com.lmw.interview._0202;


import com.lmw.leetcode.structure.ListNode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            head = head.next;
        }

        return head.val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        final ListNode listNode = ListNode.createTestData("[1,2,3,4,5]");
        System.out.println(solution.kthToLast(listNode, 2));
    }
}