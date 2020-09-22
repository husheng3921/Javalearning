package com.hs.thread.lock;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/16 19:15
 */
public class DeadLock {
    private static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            while (true){
                synchronized (object1){
                    System.out.println(Thread.currentThread().getName()+"上锁了object1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object2){
                        System.out.println(Thread.currentThread().getName()+"上锁了object2");
                    }

                }
            }
        });
        Thread thread2 = new Thread(()->{
            while (true){
                synchronized (object2){
                    System.out.println(Thread.currentThread().getName()+"上锁了object2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                   synchronized (object1){
                       System.out.println(Thread.currentThread().getName()+"上锁了object1");
                   }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
