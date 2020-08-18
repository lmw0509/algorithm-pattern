package com.lmw.leetcode._0086;


import com.lmw.leetcode.structure.ListNode;

class Solution {

    public ListNode partition(ListNode head, final int x) {
        // 构造两个链表，beforeHead小于x的节点，afterHead大于x的节点，最后将他们连在一起
        // 这里的技巧就是给两个链表都搞一个哑巴节点，也就是指向头结点的节点
        final ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        final ListNode afterHead = new ListNode(-1);
        ListNode after = afterHead;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.partition(ListNode.createTestData("[1,2,3,4,4,5,6]"),4));
    }
}
