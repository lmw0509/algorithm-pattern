package com.lmw.leetcode._0141;


import com.lmw.leetcode.structure.ListNode;

class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.hasCycle(ListNode.createTestData("[3,2,0,-4]")));
    }
}
