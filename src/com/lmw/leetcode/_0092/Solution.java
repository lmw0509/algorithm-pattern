package com.lmw.leetcode._0092;


import com.lmw.leetcode.structure.ListNode;

/**
 * 思路：先遍历到 m 处，头插法。
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
 */
class Solution {
    public ListNode reverseBetween(final ListNode head, final int m, final int n) {
        final ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int step = 0;
        while (step < m - 1) {
            g = g.next; p = p.next;
            step ++;
        }

        for (int i = 0; i < n - m; i++) {
            //待插入的节点
            final ListNode removed = p.next;

            //取出待插入的节点
            p.next = p.next.next;

            //将取出的节点插入到g节点下一位
            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.reverseBetween(ListNode.createTestData("[1,2,3,4,5,6,7]"),3,6));
    }
}
