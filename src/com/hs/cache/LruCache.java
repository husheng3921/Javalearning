package com.hs.cache;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/27/0027 16:45
 * @email husheng3921@163.com
 */
public abstract class LruCache<K, V> implements Storage<K, V> {
    //缓存容量
    protected final int capacity;

    //低速存储，所有的数据都可以从这里读到
    protected final Storage<K, V> lowSpeedStorage;

    public LruCache(int capacity, Storage<K, V> lowSpeedStorage){
        this.capacity = capacity;
        this.lowSpeedStorage = lowSpeedStorage;
    }


}
