## 基本技能

- 掌握二叉树递归与非递归遍历
- 分治法
- 理解 DFS 前序遍历
- 理解 BFS 层次遍历
- 理解并掌握平衡二叉树
- 理解并掌握二叉搜索树

## 解题模板

### 结构

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

### 遍历

> **前序遍历**：**先访问根节点**，再前序遍历左子树，再前序遍历右子树
> **中序遍历**：先中序遍历左子树，**再访问根节点**，再中序遍历右子树
> **后序遍历**：先后序遍历左子树，再后序遍历右子树，**再访问根节点**
>
> 注意点
>
> - 以根访问顺序决定是什么遍历
> - 左子树都是优先右子树
>

#### 前序递归

```java
public List<Integer> preorderTraversal(final TreeNode root) {
    if (root == null) return new ArrayList<>();

    final List<Integer> list = new ArrayList<>();
    preorderTraversal(root, list);
    return list;
}

public List<Integer> preorderTraversal(final TreeNode root, final List<Integer> list) {
    list.add(root.val);
    if (root.left != null) {
        preorderTraversal(root.left, list);
    }
    if (root.right != null) {
        preorderTraversal(root.right, list);
    }
    return list;
}
```

#### 中序递归
```java
public List<Integer> inorderTraversal(final TreeNode root) {
    final List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
}

public void helper(final TreeNode root, final List<Integer> res) {
    if (root != null) {
        if (root.left != null) {
            helper(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right, res);
        }
    }
}
```
#### 后序递归
```java
public List<Integer> postorderTraversal(final TreeNode root) {
    final List<Integer> res = new ArrayList<>();
    helper(root, res);
    return res;
}

public void helper(final TreeNode root, final List<Integer> res) {
    if (root != null) {
        if (root.left != null) {
            helper(root.left, res);
        }

        if (root.right != null) {
            helper(root.right, res);
        }

        res.add(root.val);
    }
}
```
#### 前序非递归
```java
public List<Integer> preorderTraversal(TreeNode root) {
    //非递归前序遍历，需要借助栈
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> list = new LinkedList<>();
    //当树为空树时，直接返回一个空list
    if(root == null){
        return list;
    }
    //第一步是将根节点压入栈中
    stack.push(root);
    //当栈不为空时，出栈的元素插入list尾部。
    //当它的子节点不为空时，将子节点压入栈，一定是先压右子节点再压左子节点
    while(!stack.isEmpty()){
        //此处的root只是一个变量的复用
        root = stack.pop();
        list.add(root.val);
        if(root.right != null) stack.push(root.right);
        if(root.left != null) stack.push(root.left);
    }
    return list;
}
```

#### 中序非递归
```java
public List<Integer> inorderTraversal(final TreeNode root) {
    final List<Integer> res = new ArrayList<>();
    final Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
    }
    return res;
}
```

#### 后序非递归
```java
public List<Integer> postorderTraversal(final TreeNode root) {
    final LinkedList<TreeNode> stack = new LinkedList<>();
    final LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
        return output;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
        final TreeNode node = stack.pollLast();
        output.addFirst(node.val);
        if (node.left != null) {
            stack.add(node.left);
        }
        if (node.right != null) {
            stack.add(node.right);
        }
    }
    return output;
}
```

#### DFS 前序遍历

```java
public class Solution {
    public List<Integer> dfsUpToDown(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res);
        return res;
    }
    
    public void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        dfs(node.left, res);
        dfs(node.right, res);
    }
}
```

#### BFS 层次遍历

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

#### DFS 从下向上（分治法）

```java
public class Solution {
    public List<Integer> prerderTraversal(TreeNode root) {
        return divideAndConquer(root);
    }

    public List<Integer> divideAndConquer(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        if (node == null) {
            return null;
        }
        // 分治
        List<Integer> left = divideAndConquer(node.left);
        List<Integer> right = divideAndConquer(node.right);
        // 合并结果
        result.add(node.val);
      	if (left != null) {
            result.addAll(left);
        }
        if (right != null) {
            result.addAll(right);
        }
        return result;
    }
}
```

注意点：

> DFS 深度搜索（从上到下） 和分治法区别：前者一般将最终结果通过指针参数传入，后者一般递归返回结果最后合并



### 分治法应用

先分别处理局部，再合并结果

适用场景

- 快速排序
- 归并排序
- 二叉树相关问题

分治法模板

- 递归返回条件
- 分段处理
- 合并结果

```java
// 伪代码
public class Solution {
    public ResultType traversal(TreeNode root) {
        if (root == null) {
            // do something and return
        }

        // Divide
        ResultType left = traversal(root.left);
        ResultType right = traversal(root.right);

        // Conquer
        ResultType result = Merge from left and right

        return result;
    }
}
```

#### 典型示例

```java
// 通过分治法遍历二叉树
public class Solution {
    public List<Integer> prerderTraversal(TreeNode root) {
        return divideAndConquer(root);
    }

    public List<Integer> divideAndConquer(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        if (node == null) {
            return null;
        }
        // 分治
        List<Integer> left = divideAndConquer(node.left);
        List<Integer> right = divideAndConquer(node.right);
        // 合并结果
        result.add(node.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
```

#### 归并排序  

```java
public class Solution {
    public int[] mergeSortRoot(int[] nums) {
        mergeSort(nums, 0 , nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            // 分治
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            // 合并
            merge(nums, l, mid, r);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l, j = mid + 1, k = l;
        int[] tmp = new int[nums.length];
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (i = l; i <= r; i++) {
            nums[i] = tmp[i];
        }
    }
}
```

注意点

> 递归需要返回结果用于合并

#### 快速排序  

```java
public class Solution {
    public int[] quickSort(int[] nums) {
        // 思路：把一个数组分为左右两段，左段小于右段，类似分治法没有合并过程
        quickSort(nums, 0 , nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            // pivot 是分割点，pivot左边的比nums[pivot]小，右边的比nums[pivot]大
            int pivot = partition(nums, start, end);
            quickSort(nums, 0, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int target = nums[end];
        int i = start;
        // 将小于target移到数组前面
        for (int j = start; j < end; j++) {
            if (nums[j] < target) {
                swap(nums, i, j);
                i++;
            }
        }
        // 把中间的值换为用于比较的基准值
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
```

注意点：

> 快排由于是原地交换所以没有合并过程
> 传入的索引是存在的索引（如：0、length-1 等），越界可能导致崩溃

## 常见题型

- [ ] [0094(binary-tree-inorder-traversal)](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
- [ ] [0102(binary-tree-level-order-traversal)](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
- [ ] [0144(binary-tree-preorder-traversal)](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
- [ ] [0145(binary-tree-postorder-traversal)](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)
- [ ] [剑指 Offer 32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)
- [ ] [0104(maximum-depth-of-binary-tree)](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
- [ ] [0110(balanced-binary-tree)](https://leetcode-cn.com/problems/balanced-binary-tree/)
- [ ] [0124(binary-tree-maximum-path-sum)](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
- [ ] [0236(lowest-common-ancestor-of-a-binary-tree)](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [ ] [0102(binary-tree-level-order-traversal)](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
- [ ] [0107(binary-tree-level-order-traversal-ii)](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
- [ ] [0098(validate-binary-search-tree)](https://leetcode-cn.com/problems/validate-binary-search-tree/)
- [ ] [0701(insert-into-a-binary-search-tree)](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)
- [ ] No.0270
