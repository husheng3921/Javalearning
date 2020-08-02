package com.hs.thread.communication.wait;

import javax.crypto.interfaces.PBEKey;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:49
 * @email husheng3921@163.com
 */
public class MyRunnable {
    static Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            try{
                synchronized (lock){
                    System.out.println("wait begin time="+System.currentTimeMillis());
                    lock.wait(5000);//超过时间唤醒
                    System.out.println("wait end time="+System.currentTimeMillis());
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
    static private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
                synchronized (lock){
                    System.out.println("notify begin time="+System.currentTimeMillis());
                    lock.notify();
                    System.out.println("notify end time="+System.currentTimeMillis());
                }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(runnable1);
        t.start();
        Thread.sleep(3000);
        Thread t2 = new Thread(runnable2);
        t2.start();//3秒后唤醒线程1,提前唤醒
    }
}
