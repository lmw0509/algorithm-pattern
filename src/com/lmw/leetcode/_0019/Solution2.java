package com.lmw.leetcode._0019;


import com.lmw.leetcode.structure.ListNode;

/**
 * 思路：单次遍历   删除列表中的第L-n+1个元素
 */
class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;

        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        ListNode.print(solution.removeNthFromEnd(ListNode.createTestData("[1,2,3,4,5,6]"),2));
    }
}
