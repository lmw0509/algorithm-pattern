package com.lmw.leetcode._0082;


import com.lmw.leetcode.structure.ListNode;


public class Solution {
    public ListNode deleteDuplicates(final ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 创建哑节点
        final ListNode dummy = new ListNode(-1);
        // 将哑节点加到链表头部
        dummy.next = head;

        ListNode a = dummy;

        ListNode b = head.next;

        while (b != null) {
            if (a.next.val != b.val) {
                a = a.next;
                b = b.next;
            } else {
                while (b != null && a.next.val == b.val) {
                    b = b.next;
                }
                a.next = b;
                b = b == null ? null : b.next;
            }
        }
        return dummy.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2,3,4,4,5,6,7]")));
    }
}
