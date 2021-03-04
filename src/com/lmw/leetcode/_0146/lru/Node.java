package com.lmw.leetcode._0146.lru;

/**
 * 功能描述
 *
 * @since 2021-03-04
 */
public class Node {

    public int key, val;

    public Node next, prev;

    public Node(final int k, final int v) {
        this.key = k;
        this.val = v;
    }
}
