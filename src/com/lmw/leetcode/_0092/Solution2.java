package com.lmw.leetcode._0092;

import com.lmw.leetcode.structure.ListNode;

/**
 * 思路：递归
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
 */
class Solution2 {
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(final ListNode head, final int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        final ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    // 反转链表的一部分
    ListNode reverseBetween(final ListNode head, final int m, final int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        ListNode.print(solution.reverseBetween(ListNode.createTestData("[1,2,3,4,5,6,7]"), 3, 6));
    }
}
