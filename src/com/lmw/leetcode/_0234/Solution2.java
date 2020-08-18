package com.lmw.leetcode._0234;


import com.lmw.leetcode.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.toArray().length];
        int temp = 0;
        for (int a : list) {
            arr[temp++] = a;
        }
        temp = 0;
        for (int i = 0;i < arr.length/2;i++) {
            if (arr[i] == arr[arr.length-i-1]) {
                temp++;
            }
        }
        if(temp == arr.length/2) return true;
        return false;
    }

    public static void main(final String[] args) {
        final Solution2 solution = new Solution2();
        System.out.println(solution.isPalindrome(ListNode.createTestData("[1,2,2,1]")));
    }
}
