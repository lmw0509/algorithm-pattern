package com.lmw.leetcode._0021;


import com.lmw.leetcode.structure.ListNode;

class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        // 定义临时节点，用作迭代赋值
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.mergeTwoLists(ListNode.createTestData("[1,2,4]"), ListNode.createTestData("[1,3,4]")));
    }
}
