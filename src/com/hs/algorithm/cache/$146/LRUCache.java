package com.hs.algorithm.cache.$146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/20 12:34
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    public LRUCache(int capacity){
        super(capacity,0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }
    public void put(int key, int value){
        super.put(key, value);
    }

}
