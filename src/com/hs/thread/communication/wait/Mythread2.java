package com.hs.thread.communication.wait;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:57
 * @email husheng3921@163.com
 */
public class Mythread2 extends Thread{
    private Object lock;

    public Mythread2(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
            synchronized (lock){
                System.out.println("开始     notify time="+ System.currentTimeMillis());
                lock.notify();
                System.out.println("结束     notify time="+ System.currentTimeMillis());
            }

    }
}
