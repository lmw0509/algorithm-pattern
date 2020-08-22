package com.lmw.leetcode._0232;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyQueue {

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    private Deque<Integer> in = new LinkedList<>();
    private Deque<Integer> out = new LinkedList<>();

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.addFirst(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        in2out();
        return out.removeFirst();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        in2out();
        return out.peekFirst();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }

    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.addFirst(in.removeFirst());
            }
        }
    }
}
