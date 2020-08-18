package com.lmw.leetcode._0143;


import com.lmw.leetcode.structure.ListNode;

/**
 * https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
 * 解法三
 */
class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //链表分成两个
        //右边链表
        ListNode newHead = slow.next;
        // 将链表head切断作为待排序的左边链表
        slow.next = null;

        //第二个链表倒置
        newHead = reverseList(newHead);

        //链表节点依次连接
        while (newHead != null) {
            ListNode temp = newHead.next;

            newHead.next = head.next;
            head.next = newHead;

            head = newHead.next;
            newHead = temp;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        final ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            final ListNode next = head.next;
            head.next = dummyHead.next;
            dummyHead.next = head;
            head = next;
        }
        return dummyHead.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final ListNode listNode = ListNode.createTestData("[1,2,3,4,5]");
        solution.reorderList(listNode);
        ListNode.print(listNode);
    }
}
