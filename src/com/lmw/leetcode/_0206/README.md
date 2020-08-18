题目来源于 LeetCode 上第 206 号问题：反转链表。题目难度为 Easy，目前通过率为 45.8% 。

### 题目描述

反转一个单链表。

**示例:**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

**进阶:**
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

### 题目解析

头插法，用一个 newHead 做哑节点，将链表依次插到哑节点后面。

### 动画描述

//TODO

### 代码实现

```java
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    //哑节点
    final ListNode dummyHead = new ListNode(-1);
    while (head != null) {
        //要处理的下一个节点
        final ListNode next = head.next;

        //*******插入节点到哑节点下一位*******
        //当前结点的下一个结点指向哑结点的下一个结点
        head.next = dummyHead.next;
        //哑结点的下一个结点指向当前处理的结点
        dummyHead.next = head;


        //上面操作完成了一个结点的头插,当前节点后移
        head = next;
    }
    return dummyHead.next;
}
```
