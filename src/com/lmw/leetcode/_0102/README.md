题目来源于 LeetCode 上第 102 号问题：二叉树的层序遍历。题目难度为 Medium，目前通过率为 55.8% 。

### 题目描述

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [9,20],
  [15,7]
]
```

### 题目解析

该问题需要用到**队列**

- 建立一个queue
- 先把根节点放进去，这时候找根节点的左右两个子节点
- 去掉根节点，此时queue里的元素就是下一层的所有节点
- 用for循环遍历，将结果存到一个一维向量里
- 遍历完之后再把这个一维向量存到二维向量里
- 以此类推，可以完成层序遍历

### 动画描述

![](https://blog-1257126549.cos.ap-guangzhou.myqcloud.com/blog/2elr5.gif)



### 代码实现

```java
public class Solution {
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            // size记录当前层有多少元素（遍历当前层，再添加下一层）
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
```
