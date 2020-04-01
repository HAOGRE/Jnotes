package com.haogre.ms;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description:
 * @Author : haogre@gmail.com
 * @Date : 4/1/20 10:49 AM
 * @Version : V1.0
 **/
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE = 100;

    // cacheSize 这里表示传递进来最多能缓存多少个数据

    public LRUCache(int cacheSize) {

        // 这块就是设置一个hashmap的初始大小，同时最后一个true指的是让linkedHashMap按照访问的顺序进行排序，最近访问的放在头，最老访问的就在尾部。

        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {

        //这个意思就是说，当数据量大于指定的缓存个数的时候，就自动删除最老的数据
        return size() > CACHE_SIZE;
    }
}

