package com.lmw.leetcode._0148;


import com.lmw.leetcode.structure.ListNode;

class Solution {

    public ListNode sortList(final ListNode head) {
        // 递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        // 找到链表中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        final ListNode rightHead = slow.next;
        slow.next = null;
        final ListNode left = sortList(head);
        final ListNode right = sortList(rightHead);
        return mergeLists(left, right);
    }
    private ListNode mergeLists(ListNode left, ListNode right) {
        final ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curNode.next = left;
                left = left.next;
            } else {
                curNode.next = right;
                right = right.next;
            }
            curNode = curNode.next;
        }
        curNode.next = (right != null) ? right : left;
        return dummy.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.sortList(ListNode.createTestData("[1,3,2,4,3,4,7,5]")));
    }
}
