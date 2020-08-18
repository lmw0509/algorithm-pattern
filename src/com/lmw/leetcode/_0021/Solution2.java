package com.lmw.leetcode._0021;


import com.lmw.leetcode.structure.ListNode;

class Solution2 {

    public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        ListNode.print(solution.mergeTwoLists(ListNode.createTestData("[1,2,4]"),ListNode.createTestData("[1,3,4]")));
    }
}
