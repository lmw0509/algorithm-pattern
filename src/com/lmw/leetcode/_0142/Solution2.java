package com.lmw.leetcode._0142;


import com.lmw.leetcode.structure.ListNode;

class Solution2 {

    public ListNode detectCycle(final ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { // 第一次相遇，slow回到head, fast从相遇点下一个节点开始走，
                slow = head;
                while (fast != slow) { // 第二次相遇的地方就是环的入口
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        ListNode.print(solution.detectCycle(ListNode.createTestData("[3,2,0,-4]")));
    }
}
