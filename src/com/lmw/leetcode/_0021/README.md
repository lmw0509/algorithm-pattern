题目来源于 LeetCode 上第 21 号问题：合并两个有序链表。题目难度为 Easy，目前通过率为 45.8% 。

### 题目描述

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**示例：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

### 题目解析

#### 一般方案

##### 解题思想

> 题意是用一个新链表来合并两个已排序的链表，那我们只需要从头开始比较已排序的两个链表，新链表指针每次指向值小的节点，依次比较下去，
> 最后，当其中一个链表到达了末尾，我们只需要把新链表指针指向另一个没有到末尾的链表此时的指针即可。


##### 代码实现

```java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode temp = head;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            temp.next = l1;
            l1 = l1.next;
        } else {
            temp.next = l2;
            l2 = l2.next;
        }
        temp = temp.next;
    }
    temp.next = l1 != null ? l1 : l2;
    return head.next;
}
```

#### 递归方案

##### 解题思想

> （1）对空链表存在的情况进行处理，假如 l1 为空则返回 l2 ，l2 为空则返回 l1。
> （2）比较两个链表第一个结点的大小，确定头结点的位置
> （3）头结点确定后，继续在剩下的结点中选出下一个结点去链接到第二步选出的结点后面，然后在继续重复（2 ）（3） 步，直到有链表为空。

##### 代码实现

```java
public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
    if (l1 == null) {
        return l2;
    } else if (l2 == null) {
        return l1;
    } else if (l1.val <= l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}
```