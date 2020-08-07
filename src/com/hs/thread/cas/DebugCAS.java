package com.hs.thread.cas;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 19:53
 */
public class DebugCAS implements Runnable {
    private volatile int value;
    public synchronized int compareAndSwap(int expectValue, int newValue){
        int oldValue = value;
        if (oldValue == expectValue){
            value = newValue;
            System.out.println("线程"+Thread.currentThread().getName()+"执行");
        }
        return oldValue;
    }
    @Override
    public void run() {
        compareAndSwap(100, 150);
    }

    public static void main(String[] args) throws InterruptedException{
        DebugCAS r = new DebugCAS();
        r.value = 100;
        Thread t1 = new Thread(r, "Thread 1");
        Thread t2 = new Thread(r, "Thread 2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.value);
    }
}
