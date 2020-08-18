package com.lmw.leetcode._0019;


import com.lmw.leetcode.structure.ListNode;

/**
 * 思路：两次遍历
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.removeNthFromEnd(ListNode.createTestData("[1,2,3,4,5,6]"),2));
    }
}
