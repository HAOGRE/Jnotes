package com.haogre.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/lru-cache/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-25 10:39
 * @Version : V1.0
 * LRU 缓存
 * https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 *
 */
public class Ag146 {

//    /* 缓存容量为 2 */
//    LRUCache cache = new LRUCache(2);
//    // 你可以把 cache 理解成一个队列
//    // 假设左边是队头，右边是队尾
//    // 最近使用的排在队头，久未使用的排在队尾
//    // 圆括号表示键值对 (key, val)
//
//    cache.put(1, 1);
//    // cache = [(1, 1)]
//    cache.put(2, 2);
//    // cache = [(2, 2), (1, 1)]
//    cache.get(1);       // 返回 1
//    // cache = [(1, 1), (2, 2)]
//    // 解释：因为最近访问了键 1，所以提前至队头
//    // 返回键 1 对应的值 1
//    cache.put(3, 3);
//    // cache = [(3, 3), (1, 1)]
//    // 解释：缓存容量已满，需要删除内容空出位置
//    // 优先删除久未使用的数据，也就是队尾的数据
//    // 然后把新的数据插入队头
//    cache.get(2);       // 返回 -1 (未找到)
//    // cache = [(3, 3), (1, 1)]
//    // 解释：cache 中不存在键为 2 的数据
//    cache.put(1, 4);
//    // cache = [(1, 4), (3, 3)]
//    // 解释：键 1 已存在，把原始值 1 覆盖为 4
//    // 不要忘了也要将键值对提前到队头
    /**
     * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
     * <p>
     * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
     * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     * <p>
     *  
     * <p>
     * 进阶:
     * <p>
     * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
     * <p>
     * 不能
     */

    /**
     * LinkedHashMap removeEldestEntry
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


    /**
     * 双向链表
     */
    public class LRUCache2 {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache2(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            // 使用伪头部和伪尾部节点
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    /**
     * TODO 手写简单的 LinkedHashMap
     */

}
