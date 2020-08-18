package com.lmw.leetcode._0237;


import com.lmw.leetcode.structure.ListNode;


class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
