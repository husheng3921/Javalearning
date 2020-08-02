package com.hs.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * Leetcode 146 中等
 * @author hushe
 * @date 2020/7/18/0018 9:56
 * @email husheng3921@163.com
 */
public class LRUCacheSec {
    private int size;//实际大小
    private int capacity;//容量
    private Map<Integer, DLinkedNode> map = new HashMap<>();//定义快速访问结点辅助变量
    private DLinkedNode head, tail;//定义双向链表头尾结点
    public LRUCacheSec(int capacity){
        this.capacity = capacity;
        this.size = 0;
        //头尾节点，链表初始化
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 访问结点，存在直接返回，并移到链表前面，
     * 不存在，则返回-1
     * @param key
     * @return
     */
    public int get(int key){
        DLinkedNode res = map.get(key);
        if (res != null){
            moveToHead(res);
            return res.value;
        }else{
            return -1;
        }
    }

    /**
     * 首先查找是否有该缓存，有则替换，并移动到前面；无则判断是否超容，否则插入头结点，是则移除末尾结点，再头插入
     * @param key
     * @param value
     */
    public void put(int key, int value){
        DLinkedNode node = map.get(key);
        //已存在直接替换
        if (node != null){
            node.value =value;
            moveToHead(node);
        }else{
            //加至辅助
            DLinkedNode newNode = new DLinkedNode(key, value);
            map.put(key, newNode);
            //加至头结点
            addToHead(newNode);
            size++;
            //判断缓存满则移除尾结点
            if(size > capacity){
                removeTail();
                size--;
            }
        }
    }

    //定义双向链表
    class DLinkedNode{
        //定义键值对
        int key;
        int value;
        //定义前后指针
        DLinkedNode pre;
        DLinkedNode next;
        //定义构造函数
        public DLinkedNode(){}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    /**
     * 定义链表基本操作方法
     * 1.头插入结点(缓存被访问后更新到头结点,存在则移动，不存在直接插入)-基础方法
     * 2.删除结点(缓存被访问中，删除原来位置，移到头结点）-基础方法
     * 3.移到前面-二次整合方法
     * 4.删除末尾结点（缓存超出容量，需要删除末尾结点）-二次整合方法
     */

    /**
     * 定义 头插入结点
     * @param node
     */
    public void addToHead(DLinkedNode node){
        //没有辅助结点，注意顺序
       /* node.pre = head;
        node.next = head.next;//连接两侧
        node.next.pre = node;
        head.next = node;*/
        DLinkedNode nextNode = head.next;//暂存除头结点外的第一个结点
        head.next = node;
        node.next = nextNode;//首先把两边结点都连起来
        nextNode.pre = node;
        node.pre = head;
    }

    /**
     * 删除双向链表中的结点
     * @param node
     */
    public void removeNode(DLinkedNode node){
        //没有辅助结点
        /*node.pre.next = node.next;
        node.next.pre = node.pre;*/
        //辅助结点
        DLinkedNode preNode = node.pre;
        DLinkedNode nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    /**
     * 移动结点到前面
     * @param node
     */
    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除末尾非尾结点
     * @return
     */
    public DLinkedNode removeTail(){
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
