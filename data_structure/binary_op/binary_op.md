## 常见二进制操作

### 基本操作

a=0^a=a^0

0=a^a

由上面两个推导出：a=a^b^b

### 交换两个数

a=a^b

b=a^b

a=a^b

### 移除最后一个 1

a=n&(n-1)

### 获取最后一个 1

diff=(n&(n-1))^n

### 位运算概览
| 符号 | 描述 | 运算规则                                                     |
| :--- | :--- | :----------------------------------------------------------- |
| &    | 与   | 两个位都为1时，结果才为1                                     |
| \|   | 或   | 两个位都为0时，结果才为0                                     |
| ^    | 异或 | 两个位相同为0，相异为1                                       |
| ~    | 取反 | 0变1，1变0                                                   |
| <<   | 左移 | 各二进位全部左移若干位，高位丢弃，低位补0                    |
| >>   | 右移 | 各二进位全部右移若干位，对无符号数，高位补0，有符号数，各编译器处理方法不一样，有的补符号位（算术右移），有的补0（逻辑右移） |

### 常见题型

[single-number-iii](https://leetcode-cn.com/problems/single-number-iii/)

> 给定一个整数数组  `nums`，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
详解见[https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leetcode/](https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leetcode/)
```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        // 这个循环只会保留出现一次的数，假设两个出现一次的数为x、y, x和y都被保存在bitmask里面，下面把他们分离出来
        for (int num : nums) {
            bitmask ^= num;
        }
        // 保留二进制数，最右边为1的值，其他为都为0，这个1要么是x的要么是y的
        int diff = bitmask & (-bitmask);
        int x = 0;
        // 这个循环确定diff是x的还是y的，并保存起来
        for (int num : nums) {
            if ((diff & num) != 0) {
                x ^= num;
            }
        }
        // y = bitmask ^ x;
        return new int[]{x, bitmask ^ x};
    }
}
```

[counting-bits](https://leetcode-cn.com/problems/counting-bits/)

> 给定一个非负整数  **num**。对于  0 ≤ i ≤ num  范围中的每个数字  i ，计算其二进制数中的 1 的数目并将它们作为数组返回。


```java
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = count(i);
        }
        return res;
    }
    
    private int count(int num) {
        int sum = 0;
        while (num != 0) {
            sum++;
            num &= num - 1;
        }
        return sum;
    }
}
```

另外一种动态规划解法

```java
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // 上一个缺1的元素+1即可
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
```

[reverse-bits](https://leetcode-cn.com/problems/reverse-bits/)

> 颠倒给定的 32 位无符号整数的二进制位。

思路：依次颠倒即可

取当前 n 的最后一位：n & 1
将最后一位移动到对应位置，第一次为 31 位，第二次是 30 位，即：31、30、29... 1、0，写作代码 bit << 31;
退出条件，二进制反转时，如果剩余位数全位 0，则可以不用再反转。
```java
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsize = 31; n != 0; n = n >>> 1, bitsize--) {
            ans += (n & 1) << bitsize;
        }
        return ans;
    }
}
```

## 练习

- [ ] [No.0136(single-number)](https://leetcode-cn.com/problems/single-number/)
- [ ] [No.0137(single-number-ii)](https://leetcode-cn.com/problems/single-number-ii/)
- [ ] [No.0260(single-number-iii)](https://leetcode-cn.com/problems/single-number-iii/)
- [ ] [No.0191(number-of-1-bits)](https://leetcode-cn.com/problems/number-of-1-bits/)
- [ ] [No.0338(counting-bits)](https://leetcode-cn.com/problems/counting-bits/)
- [ ] [No.0190(reverse-bits)](https://leetcode-cn.com/problems/reverse-bits/)
- [ ] [No.0201(bitwise-and-of-numbers-range)](https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/)
