package com.lmw.leetcode._0206;


import com.lmw.leetcode.structure.ListNode;


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //哑节点
        final ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            //要处理的下一个节点
            final ListNode next = head.next;

            //*******插入节点到哑节点下一位*******
            //当前结点的下一个结点指向哑结点的下一个结点
            head.next = dummyHead.next;
            //哑结点的下一个结点指向当前处理的结点
            dummyHead.next = head;


            //上面操作完成了一个结点的头插,当前节点后移
            head = next;
        }
        return dummyHead.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.reverseList(ListNode.createTestData("[1,2,3,4,5]")));
    }
}

