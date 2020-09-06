### Description

Implement [strStr()](http://www.cplusplus.com/reference/cstring/strstr/).

Return the index of the first occurrence of needle in haystack, or **-1** if needle is not part of haystack.

**Example 1:**

```
Input: haystack = "hello", needle = "ll"
Output: 2
```

**Example 2:**

```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```

**Clarification:**

What should we return when `needle` is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when `needle` is an empty string. This is consistent to C's [strstr()](http://www.cplusplus.com/reference/cstring/strstr/) and Java's [indexOf()](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#indexOf(java.lang.String)).

Tags:** Two Pointers, String

### 代码实现一：两次遍历

```java
class Solution {
    public int strStr(final String haystack, final String needle) {
        final int l1 = haystack.length();
        final int l2 = needle.length();
        if (l1 < l2) {
            return -1;
        }
        for (int i = 0; i < l1 - l2 + 1; i++) {
            for (int j = 0; j < l2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == l2 - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
```

### 代码实现二：一次遍历+substring

```java
class Solution2 {
    public int strStr(final String haystack, final String needle) {
        final int l1 = haystack.length();
        final int l2 = needle.length();
        for (int start = 0; start < l1 - l2 + 1; ++start) {
            if (haystack.substring(start, start + l2).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
```
