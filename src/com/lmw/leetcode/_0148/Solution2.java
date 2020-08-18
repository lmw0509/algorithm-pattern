package com.lmw.leetcode._0148;


import com.lmw.leetcode.structure.ListNode;

class Solution2 {

    public ListNode sortList(final ListNode head) {
        ListNode currentHead;
        ListNode mergeHead1;
        ListNode mergeHead2;
        ListNode preNode;
        final ListNode dummy;
        currentHead = head;
        int length = 0, currentMergeNumber = 1;
        while (currentHead != null) {
            currentHead = currentHead.next;
            length++;
        }
        dummy = new ListNode(0);
        dummy.next = head;
        while (currentMergeNumber < length) {
            preNode = dummy;
            currentHead = dummy.next;
            while (currentHead != null) {
                int i = currentMergeNumber;
                mergeHead1 = currentHead;
                while (i > 0 && currentHead != null) {
                    currentHead = currentHead.next;
                    i--;
                }
                if (i > 0) {
                    break;
                }
                i = currentMergeNumber;
                mergeHead2 = currentHead;
                while (i > 0 && currentHead != null) {
                    currentHead = currentHead.next;
                    i--;
                }
                int lengthOfHead1 = currentMergeNumber, lengthOfHead2 = currentMergeNumber - i;
                while (lengthOfHead1 > 0 && lengthOfHead2 > 0) {
                    if (mergeHead1.val < mergeHead2.val) {
                        preNode.next = mergeHead1;
                        mergeHead1 = mergeHead1.next;
                        lengthOfHead1--;
                    } else {
                        preNode.next = mergeHead2;
                        mergeHead2 = mergeHead2.next;
                        lengthOfHead2--;
                    }
                    preNode = preNode.next;
                }
                preNode.next = lengthOfHead1 == 0 ? mergeHead2 : mergeHead1;
                while (lengthOfHead1 > 0 || lengthOfHead2 > 0) {
                    preNode = preNode.next;
                    lengthOfHead1--;
                    lengthOfHead2--;
                }
                preNode.next = currentHead;
            }
            currentMergeNumber *= 2;
        }
        return dummy.next;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        ListNode.print(solution.sortList(ListNode.createTestData("[1,3,2,4,3,4,7,5]")));
    }
}
