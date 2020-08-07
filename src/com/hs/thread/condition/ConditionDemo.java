package com.hs.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 19:03
 */
public class ConditionDemo {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    void method1()throws InterruptedException{
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"条件不满足，开始await");
            condition.await();
            System.out.println(Thread.currentThread().getName()+"条件满足，开始执行后续的任务");
        }finally {
            lock.unlock();
        }
    }
    void method2()throws InterruptedException{
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"需要5秒中的准备时间");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+"准备工作完成，唤醒其他线程");
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo demo = new ConditionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    demo.method2();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        demo.method1();
    }

}
