package com.lmw.leetcode._0150;


import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a = 0, b = 0;
        for (String val : tokens) {
            if ("+-*/".contains(val)) {
                a = stack.pop();
                b = stack.pop();
            }
            switch (val) {
                case "+":
                    stack.push(b + a);
                    break;
                case "-":
                    stack.push(b - a);
                    break;
                case "*":
                    stack.push(b * a);
                    break;
                case "/":
                    stack.push(b / a);
                    break;
                default:
                    stack.push(new Integer(val));
            }
        }
        return stack.pop();
    }

}
