package com.hs.cache;

import java.util.LinkedHashMap;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/29 20:16
 */
public class SimpleLRU<K, V> {
    private final int MAX_CACHE_SIZE;
    private final float DEFAULT_LOAD_FACTORY = 0.75f;
    LinkedHashMap<K,V> map;
    public SimpleLRU(int cacheSize){
        MAX_CACHE_SIZE = cacheSize;
        int capacity = (int)Math.ceil(MAX_CACHE_SIZE/DEFAULT_LOAD_FACTORY)+1;
        map = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTORY, true){

            private static final long serialVersionUID = 1L;

            @Override
            public boolean remove(Object key, Object value) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }
    public synchronized V get(K key){
        return map.get(key);
    }
    public synchronized void put(K key, V value){
        map.put(key, value);
    }
    public synchronized int userdSize(){
        return map.size();
    }
}
