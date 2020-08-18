package com.lmw.leetcode._0083;

import com.lmw.leetcode.structure.ListNode;

public class Solution2 {
    public ListNode deleteDuplicates(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2]")));
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2,3,3]")));
    }
}
