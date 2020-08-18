题目来源于 LeetCode 上第 107 号问题：二叉树的层次遍历 II。题目难度为 Easy，目前通过率为 55.8% 。

### 题目描述

给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其自底向上的层次遍历为：

```
[
  [15,7],
  [9,20],
  [3]
]
```

### 题目解析

该问题需要用到**队列**，解法与上篇[每天一算：Binary Tree Level Order Traversal](https://xiaozhuanlan.com/topic/8579460312)类似，区别在于最后存储方式的不同。

- 建立一个 queue
- 先把根节点放进去，这时候找根节点的左右两个子节点
- 去掉根节点，此时queue里的元素就是下一层的所有节点
- 用 for 循环遍历，将结果存到一个一维向量里
- 遍历完之后再把这个一维向量**插入**到二维向量里
- 以此类推，可以完成层序遍历



### 动画描述

![](https://blog-1257126549.cos.ap-guangzhou.myqcloud.com/blog/varp8.gif)



### 代码实现

#### BFS

```java
//题意是从下往上按层遍历二叉树，每一层是从左到右，按层遍历，很明显，宽搜第一时间符合，
//因为是从下往上，所以插入的时候每次插到链表头即可。
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new LinkedList();
            for(int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                sub.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            list.add(0, sub);
        }
        return list;
    }
}
```



#### DFS

```java
//深搜的时候同时记录深度，然后在相应的层插入节点值即可。
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helper(list, root, 0);
        return list;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
```

