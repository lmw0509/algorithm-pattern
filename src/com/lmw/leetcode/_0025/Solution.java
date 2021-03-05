package com.lmw.leetcode._0025;

import com.lmw.leetcode.structure.ListNode;

/**
 * https://zhuanlan.zhihu.com/p/90170262
 *
 * @since 2021-03-05
 */
public class Solution {

    // 反转以 a 为头结点的链表
    public ListNode reverse(final ListNode a) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        while (cur != null) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    // 反转区间 [a, b) 的元素，注意是左闭右开
    public ListNode reverse(final ListNode a, final ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    // 反转部分链表
    public ListNode reverseKGroup(final ListNode head, final int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        final ListNode newHead = reverse(head, b);
        // 递归反转后续链表并连接起来
        head.next = reverseKGroup(b, k);
        return newHead;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.reverse(ListNode.createTestData("[1,2,3,4,5,6,7]")));
        // ListNode.print(solution.reverse(ListNode.createTestData("[1,2,3,4,5,6,7]"),
        // ListNode.createTestData("[6,7]")));
        ListNode.print(solution.reverseKGroup(ListNode.createTestData("[1,2,3,4,5,6,7]"), 2));
    }
}
