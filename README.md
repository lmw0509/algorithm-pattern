## 数据结构与算法

> 数据结构是一种数据的表现形式，如链表、二叉树、栈、队列等都是内存中一段数据表现的形式。
>
> 算法是一种通用的解决问题的模板或者思路，大部分数据结构都有一套通用的算法模板，所以掌握这些通用的算法模板即可解决各种算法问题。
>
> 数据结构和算法有技巧，通过模板刷题是最科学的刷题方式，最快速的刷题路径。

本项目会分专题讲解各种数据结构、基本的算法模板和一些高级算法模板，每一个专题都有一些经典练习题，完成所有练习的题后，你对数据结构和算法会有新的收获和体会。

## 在线文档

在线文档 Gitbook：[算法模板 🔥](https://greyireland.gitbook.io/algorithm-pattern/)

## 核心内容

### 入门篇 🐶

- [算法快速入门](./quickstart.md)

### 数据结构篇 🐰

- [二进制](./data_structure/binary_op/binary_op.md)
- [数组](./data_structure/array)
- [链表](./data_structure/linked_list/linked_list.md)
- [栈和队列](./data_structure/stack_queue/stack_queue.md)
- [哈希表](./data_structure/hash/hash.md)
- [跳表](./data_structure/skip_list/skip_list.md)
- [二叉树](./data_structure/binary_tree/binary_tree.md)
- [二叉搜索树](./data_structure/binary_search_tree/binary_search_tree.md)
- [字典树](./data_structure/trie/trie.md)
- [图](./data_structure/graph/)


### 基础算法篇 🐮

- [递归](./basic_algorithm/recursion/README.md)
- [二分搜索](./basic_algorithm/binary_search/README.md)
- [排序算法](./basic_algorithm/sort/README.md)
- [动态规划](./basic_algorithm/dp/README.md)

### 算法思维 🦁

- [回溯法](./advanced_algorithm/backtrack/README.md)
- [AC自动机](./advanced_algorithm/ac_automata)
- [字符串匹配](./advanced_algorithm/BF_RK/README.md)
- [滑动窗口思想](./advanced_algorithm/slide_window/README.md)

## 推荐的刷题路径

按此 repo 目录刷一遍，如果中间有题目卡住了先跳过，然后刷题一遍 LeetCode 探索基础卡片，最后快要面试时刷题一遍剑指 offer。

为什么这么要这么刷，因为 repo 里面的题目是按类型归类，都是一些常见的高频题，很有代表性，大部分都是可以用模板加一点变形做出来，刷完后对大部分题目有基本的认识。
然后刷一遍探索卡片，巩固一下一些基础知识点，总结这些知识点。
最后剑指 offer 是大部分公司的出题源头，刷完面试中基本会遇到现题或者变形题，基本刷完这三部分，大部分国内公司的面试题应该就没什么问题了~

1、 [algorithm-pattern 练习题](https://greyireland.gitbook.io/algorithm-pattern/)

![练习题](https://img.fuiboom.com/img/repo_practice.png)

2、 [LeetCode 卡片](https://leetcode-cn.com/explore/)

![探索卡片](https://img.fuiboom.com/img/leetcode_explore.png)

3、 [剑指 offer](https://leetcode-cn.com/problemset/lcof/)

![剑指offer](https://img.fuiboom.com/img/leetcode_jzoffer.png)

刷题时间可以合理分配，如果打算准备面试了，建议前面两部分 一个半月 （6 周）时间刷完，最后剑指 offer 半个月刷完，边刷可以边投简历进行面试，遇到不会的不用着急，往模板上套就对了，如果面试管给你提示，那就好好做，不要错过这大好机会~

> 注意点：如果为了找工作刷题，遇到 hard 的题如果有思路就做，没思路先跳过，先把基础打好，再来刷 hard 可能效果会更好~

## 面试注意点

我们大多数时候，刷算法题可能都是为了准备面试，所以面试的时候需要注意一些点

- 快速定位到题目的知识点，找到知识点的**通用模板**，可能需要根据题目**特殊情况做特殊处理**。
- 先去朝一个解决问题的方向！**先抛出可行解**，而不是最优解！先解决，再优化！
- 代码的风格要统一，熟悉各类语言的代码规范。
  - 命名尽量简洁明了，尽量不用数字命名如：i1、node1、a1、b2
- 常见错误总结
  - 访问下标时，不能访问越界
  - 空值 null 问题 run time error
