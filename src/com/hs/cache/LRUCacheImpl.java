package com.hs.cache;

import java.util.HashMap;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/27/0027 16:50
 * @email husheng3921@163.com
 */
public class LRUCacheImpl<K, V> extends LruCache<K, V> {

    HashMap<K, Node> map = new HashMap<>();
    //声明头尾结点
    Node head = null;
    Node tail = null;

    public LRUCacheImpl(int capacity, Storage<K, V> lowSpeedStorage) {
        super(capacity, lowSpeedStorage);
    }


    @Override
    public V get(K key) {
        //查询缓存有不有数据
        V v1 = getValue(key);
        //缓存内存不在
        if (v1 == null){
            //查询lowSpeedStorage,查询磁盘
            V v2 = lowSpeedStorage.get(key);
            if (v2 != null){
                //lowSpeedStorage存在，将它放入缓存
                set(key, v2);
            }
            return v2;
        }
        return v1;
    }
    //获取一个缓存数据之后，应该把这个数据在当前位置中移除，并重新加到头位置，这些都是返回数据之前完成
    public V getValue(K key){
        if (map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return null;
    }

    //移除元素Node n
    public void remove(Node n){
        if (n.pre != null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
        if (n.next != null){
            n.next.pre = n.pre;
        }else {
            tail = n.pre;
        }
    }

    public void setHead(Node n){
        n.next = head;//head原位置指向第一个元素，现在把这个位置给n.next
        n.pre = null;
        if (head != null){
            head.pre = n;
        }
        head = n;

        if (tail == null){
            tail = head;
        }
    }
    //看原位置是否有元素，如果有就替换，这证明使用过了，然后将其替换为头结点的元素
    public void set(K key, V value){
        if (map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node tmp = new Node(key, value);
            if (map.size() >= capacity){
                map.remove(tail.key);
                remove(tail);
                setHead(tmp);
            }else{
                setHead(tmp);
            }
            map.put(key,tmp);
        }
    }
    class Node{
        K key;
        V value;
        Node pre;
        Node next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
