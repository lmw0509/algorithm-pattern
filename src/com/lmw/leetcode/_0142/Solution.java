package com.lmw.leetcode._0142;


import com.lmw.leetcode.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }

        return null;
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        ListNode.print(solution.detectCycle(ListNode.createTestData("[3,2,0,-4]")));
    }
}
