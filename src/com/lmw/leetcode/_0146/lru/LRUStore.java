package com.lmw.leetcode._0146.lru;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @since 2021-03-04
 */
public class LRUStore {
    // key -> Node(key, val)
    private final HashMap<Integer, Node> map;

    // Node(k1, v1) <-> Node(k2, v2)...
    private final DoubleList cache;

    // 最大容量
    private final int cap;

    public LRUStore(final int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(final int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        final int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(final int key, final int val) {
        // 先把新节点 x 做出来
        final Node x = new Node(key, val);
        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                final Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}
