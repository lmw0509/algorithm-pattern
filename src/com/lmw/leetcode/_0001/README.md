题目来源于 LeetCode 上第 1 号问题：两数之和。题目难度为 Easy，目前通过率为 45.8% 。

### 题目描述

给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

**示例:**

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

### 题目解析

利用 HashMap 作为存储，键为目标值减去当前元素值，索引为值，比如 `i = 0` 时，此时首先要判断 `nums[0] = 2` 是否在 map 中，如果不存在，那么插入键值对 `key = 9 - 2 = 7, value = 0`，之后当 `i = 1` 时，此时判断 `nums[1] = 7` 已存在于 map 中，那么取出该 `value = 0` 作为第一个返回值，当前 `i` 作为第二个返回值，具体代码如下所示。

### 动画描述

![](./Animation.gif)

### 代码实现一

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            final Integer value = map.get(nums[i]);
            if (value != null) {
                return new int[] { value, i };
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
```



### 代码实现二

```java
//题意是让你从给定的数组中找到两个元素的和为指定值的两个索引，
//最容易的当然是循环两次，复杂度为 `O(n^2)`，首次提交居然是 2ms，
//打败了 100% 的提交，谜一样的结果，之后再次提交就再也没跑到过 2ms 了。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
```

