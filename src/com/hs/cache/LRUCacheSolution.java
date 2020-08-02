package com.hs.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/6/24/0024 16:26
 * @email husheng3921@163.com
 */
public class LRUCacheSolution {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode  pre;
        DLinkedNode  next;
        public DLinkedNode (){}
        public DLinkedNode (int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode > map = new HashMap<>();
    private int size;//大小
    private int capacity;//容量
    private DLinkedNode  head, tail;//双向链表头尾指针

    //初始化
    public LRUCacheSolution(int capacity){
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部和伪尾部结点
        tail = new DLinkedNode ();
        head = new DLinkedNode ();
        head.next = tail;
        tail.pre = head;
        //空双向链表有两个结点，size=0，
    }
    //缓存操作
    public void put(int key, int value){
        DLinkedNode  node = map.get(key);
        if (node == null){//不存在，则加入map和头部
            DLinkedNode  newNode = new DLinkedNode (key, value);
            map.put(key,newNode);
            //加入头部
            addToHead(newNode);
            ++size;//计数加
            if (size > capacity){
                //超出容量，删除末尾结点
                //获取尾结点,并删除
                DLinkedNode  tail = removeTail();
                //移除
                map.remove(tail.key);
                --size;
            }
        }else{//已存在，修改原值,移到前面
            node.value = value;
            moveToHead(node);
        }
    }
    public int get(int key){
        DLinkedNode  node = map.get(key);
        if (node == null){
            return -1;
        }
        //存在，则移动到前面
        moveToHead(node);
        return node.value;
    }

    //链表基本操作
    private void addToHead(DLinkedNode  node){
        node.pre = head;
        node.next = head.next;//连接两侧
        node.next.pre = node;
        head.next = node;
    }

    //移除node
    private void removeNode(DLinkedNode  node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    //移到前面
    private void moveToHead(DLinkedNode  node){
        removeNode(node);
        addToHead(node);
    }
    //删除末尾
    private DLinkedNode  removeTail(){
        DLinkedNode  res = tail.pre;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCacheSolution cache = new LRUCacheSolution(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
