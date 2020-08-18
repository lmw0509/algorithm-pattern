题目来源于 LeetCode 上第 82 号问题：删除排序链表中的重复元素。题目难度为 Medium，目前通过率为 48.7% 。

### 题目描述

给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 *没有重复出现* 的数字。

**示例 1:**

```
输入: 1->2->3->3->4->4->5
输出: 1->2->5
```

**示例 2:**

```
输入: 1->1->1->2->3
输出: 2->3
```

### 题目解析

链表是排过序的，重复数字的节点只可能在一起。

- 创建两个指针前后a，b紧贴着往下走
- a，b的节点值相等的时候，b继续往下走看是否还有重复的
- a.next = b

### 动画描述

//TODO

### 代码实现

```java
public ListNode deleteDuplicates(final ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    // 创建哑节点
    final ListNode dummy = new ListNode(-1);
    // 将哑节点加到链表头部
    dummy.next = head;

    ListNode a = dummy;

    ListNode b = head.next;

    while (b != null) {
        if (a.next.val != b.val) {
            a = a.next;
            b = b.next;
        } else {
            while (b != null && a.next.val == b.val) {
                b = b.next;
            }
            a.next = b;
            b = b == null ? null : b.next;
        }
    }
    return dummy.next;
}
```
