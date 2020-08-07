package com.hs.thread.condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by husheng02.
 * 调用await必须持有锁，否则会抛出异常
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 19:10
 */
public class MyBlockingQueueForCondition {
    private Queue queue;
    private int max = 16;
    private ReentrantLock lock = new ReentrantLock();
    /**
     * notempty表示队列没有空的条件
     * notfull 队列没有满的条件
     */
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlockingQueueForCondition(int size){
        this.max = size;
        queue = new LinkedList();
    }
    public void put(Object o)throws InterruptedException{
        //对应synchronized
        lock.lock();
        try{
            while (queue.size() == max){
                //await 自动释放锁，对应Object.wait
                notFull.await();
            }
            queue.add(o);
            //丢用Object.notifyAll()
            notEmpty.signalAll();
        }finally {
            //对应synchronized
            lock.unlock();
        }
    }
    public Object take()throws InterruptedException{
        lock.lock();
        try{
            while (queue.size() == 0){
                notEmpty.await();
            }
            Object item = queue.poll();
            notFull.signalAll();
            return item;
        }finally {
            lock.unlock();
        }
    }
}
