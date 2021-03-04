package com.lmw.leetcode._0146.lru;

/**
 * 功能描述
 *
 * @since 2021-03-04
 */
public class DoubleList {

    private Node head, tail;

    private int size;

    // 在链表头部添加节点 x，时间 O(1)
    public void addFirst(final Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            final Node n = head;
            n.prev = node;
            node.next = n;
            head = node;
        }
        size++;
    }

    // 删除链表中的 x 节点（x一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(final Node node) {
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (tail == node) {
            node.prev.next = null;
            tail = node.prev;
        } else if (head == node) {
            node.next.prev = null;
            head = node.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点，时间 O(1)
    public Node removeLast() {
        final Node node = tail;
        remove(tail);
        return node;
    }

    // 返回链表长度，时间 O(1)
    public int size() {
        return size;
    }

}
