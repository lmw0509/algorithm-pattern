package com.lmw.leetcode._0019;

import com.lmw.leetcode.structure.ListNode;

/**
 * 思路：两次遍历
 */
class Solution {
    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        // 哑巴节点把快慢指针拎起来
        final ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // 快指针先走n个节点，使快指针和慢指针之间的间隙是n个节点分开的
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // 同时步进两个指针，直到快指针走完
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        /** 单链删除元素的关键步骤 **/
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.removeNthFromEnd(ListNode.createTestData("[1,2,3,4,5,6]"), 2));
    }
}
