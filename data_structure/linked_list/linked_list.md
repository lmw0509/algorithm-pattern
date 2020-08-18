## 基本技能

链表相关的核心点

- null/nil 异常处理
- dummy node 哑巴节点（当头节点不确定的时候，使用哑巴节点）
- 快慢指针
- 插入一个节点到排序链表
- 从一个链表中移除一个节点
- 翻转链表
- 合并两个链表
- 找到链表的中间节点

## 解题模板

### 单向链表定义

```java
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
```

### 打印链表

```java
public void printAll(ListNode ln) {
    ListNode p = ln;
    while (p != null) {
        System.out.print(p.val + " ");
        p = p.next;
    }
    System.out.println();
}
```

### 单向链表反转

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

### 单向链表合并

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

### 中间节点

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

### 环形链表

```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            return true;
        }
    }
    return false;
}
```

### 删除节点

```java
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}
```

### 删除倒数第n个节点

```java
//两次遍历
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}

//单次遍历
//删除列表中的第L-n+1个元素
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length  = 0;
    ListNode first = head;
    while (first != null) {
        length++;
        first = first.next;
    }
    length -= n;
    
    first = dummy;
    while (length > 0) {
        length--;
        first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
}
```

### 判断是否回文

```java
public boolean isPalindrome(final ListNode head) {
    if (head == null || head.next == null) {
        return true;
    }
    //找中点
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    //链表分成两个
    //右边链表
    ListNode newHead = slow.next;
    // 将链表head切断作为待排序的左边链表
    slow.next = null;


    // 将右边链表翻转，然后判断两边链表是否相等
    return isEqual(head, reverseList(newHead));
}

private ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    final ListNode dummyHead = new ListNode(-1);
    while (head != null) {
        final ListNode next = head.next;
        head.next = dummyHead.next;
        dummyHead.next = head;
        head = next;
    }
    return dummyHead.next;
}

private boolean isEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
        if (l1.val != l2.val) {
            return false;
        }
        l1 = l1.next;
        l2 = l2.next;
    }
    return true;
}
```



## 常见题型

- [ ] [No.0019(remove-nth-node-from-end-of-list)](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)
- [ ] [No.0021(merge-two-sorted-lists)](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
- [ ] [No.0083(remove-duplicates-from-sorted-list)](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)
- [ ] [No.0082(remove-duplicates-from-sorted-list-ii)](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)
- [ ] [No.0086(partition-list)](https://leetcode-cn.com/problems/partition-list/)
- [ ] [No.0092(reverse-linked-list-ii)](https://leetcode-cn.com/problems/reverse-linked-list-ii/)
- [ ] [No.0141(linked-list-cycle)](https://leetcode-cn.com/problems/linked-list-cycle/)
- [ ] [No.0142(linked-list-cycle-ii)](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
- [ ] [No.0143(reorder-list)](https://leetcode-cn.com/problems/reorder-list/)
- [ ] [No.0148(sort-list)](https://leetcode-cn.com/problems/sort-list/)
- [ ] [No.0206(reverse-linked-list)](https://leetcode-cn.com/problems/reverse-linked-list/)
- [ ] [No.0234(palindrome-linked-list)](https://leetcode-cn.com/problems/palindrome-linked-list/)
- [ ] [No.237(delete-node-in-a-linked-list)](https://leetcode-cn.com/problems/delete-node-in-a-linked-list/)
- [ ] [No.0876(middle-of-the-linked-list)](https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/)
