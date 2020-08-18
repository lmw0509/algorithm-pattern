package com.lmw.leetcode._0234;


import com.lmw.leetcode.structure.ListNode;

class Solution {
    public boolean isPalindrome(final ListNode head) {
        if (head == null || head.next == null) {
            return true;
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


        // 将右边链表翻转，然后判断两边链表是否相等
        return isEqual(head, reverseList(newHead));
    }

    private ListNode reverseList(ListNode head) {
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

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }




    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.isPalindrome(ListNode.createTestData("[1,2,2,1]")));
    }
}
