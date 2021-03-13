package com.lmw.leetcode._0225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://zhuanlan.zhihu.com/p/107761819
 *
 * @since 2021-03-08
 */
public class Stack {
    Queue<Integer> queue1;

    Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public Stack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(final int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        final Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }
}
