package com.lmw.leetcode._0876;


import com.lmw.leetcode.structure.ListNode;

/**
 * 思路：快慢指针
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.middleNode(ListNode.createTestData("[1,2,3,4,5,6]")));
    }
}
