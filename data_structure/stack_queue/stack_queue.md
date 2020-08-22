## 概述

- 熟悉栈的使用场景

  - 后进先出，保存临时值
  - 利用栈 DFS 深度搜索

  ![image.png](https://img.fuiboom.com/img/stack.png)

  

- 熟悉队列的使用场景

  - 利用队列 BFS 广度搜索

## Stack 栈

利用栈进行 BFS 非递归搜索模板

```java
// 伪代码
public class Solution 
    boolean BFS(Node root, int target) {
        Set<Node> visited;
        Stack<Node> s;
        add root to s;
        while (s is not empty) {
            Node cur = the top element in s;
            return true if cur is target;
            for (Node next : the neighbors of cur) {
                if (next is not in visited) {
                    add next to s;
                    add next to visited;
                }
            }
            remove cur from s;
        }
        return false;
    }
}
```

[min-stack](https://leetcode-cn.com/problems/min-stack/)

[evaluate-reverse-polish-notation](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/)

[decode-string](https://leetcode-cn.com/problems/decode-string/)

[clone-graph](https://leetcode-cn.com/problems/clone-graph/)

[number-of-islands](https://leetcode-cn.com/problems/number-of-islands/)

[largest-rectangle-in-histogram](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

## Queue 队列

[implement-queue-using-stacks](https://leetcode-cn.com/problems/implement-queue-using-stacks/)

[01-matrix](https://leetcode-cn.com/problems/01-matrix/)