package com.hs.thread.condition;

import java.util.LinkedList;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 19:17
 */
public class MyBlockingQueueForWaitNotify {
    private int maxSize;
    private LinkedList<Object> storage;

    public MyBlockingQueueForWaitNotify(int size){
        this.maxSize = size;
        storage = new LinkedList<>();
    }

    public synchronized void put() throws InterruptedException{
        while (storage.size() == maxSize){
            this.wait();
        }
        storage.add(new Object());
        this.notifyAll();
    }
    public synchronized Object take() throws InterruptedException{
        while (storage.size() == 0){
            this.wait();
        }
        Object item = storage.pop();
        this.notifyAll();
        return item;
    }
}
