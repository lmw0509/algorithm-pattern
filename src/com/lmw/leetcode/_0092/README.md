题目来源于 LeetCode 上第 92 号问题：反转链表 II。题目难度为 Medium，目前通过率为 43.8% 。

### 题目描述

反转从位置 *m* 到 *n* 的链表。请使用一趟扫描完成反转。

**说明:**
1 ≤ *m* ≤ *n* ≤ 链表长度。

**示例:**

```
输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
```

### 题目解析

思路：双指针，先遍历到 m 处，再头插法。

https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/

和0206的区别，0206生成一条新的单链存储结果数据。本题没有生成新的单链，只是调整顺序。

### 动画描述

//TODO

### 代码实现

```java
public ListNode reverseBetween(final ListNode head, final int m, final int n) {
    final ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode g = dummyHead;
    ListNode p = dummyHead.next;

    int step = 0;
    while (step < m - 1) {
        g = g.next; p = p.next;
        step ++;
    }

    for (int i = 0; i < n - m; i++) {
        //待插入的节点
        final ListNode removed = p.next;

        //取出待插入的节点
        p.next = p.next.next;

        //将取出的节点插入到g节点下一位
        removed.next = g.next;
        g.next = removed;
    }

    return dummyHead.next;
}
```

