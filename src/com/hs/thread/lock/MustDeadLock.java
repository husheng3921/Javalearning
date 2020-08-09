package com.hs.thread.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 12:27
 */
public class MustDeadLock implements Runnable{
    public int flag;
    static Object o1 = new Object();
    static Object o2 = new Object();
    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"的flag:"+flag);
        if (flag == 1){
            synchronized (o1){
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("线程1获得了两把锁");
                }
            }
        }
        if (flag == 2){
            synchronized (o2){
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("线程2获得了两把锁");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MustDeadLock r1 = new MustDeadLock();
        MustDeadLock r2 = new MustDeadLock();
        r1.flag = 1;
        r2.flag = 2;
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockThreads = threadMXBean.findDeadlockedThreads();
        if(deadlockThreads != null && deadlockThreads.length >0){
            for (int i = 0; i < deadlockThreads.length; i++){
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockThreads[i]);
                System.out.println("线程id为"+ threadInfo.getThreadId()+",线程名为"+threadInfo.getThreadName()+"的线程已经发生死锁，需要的锁证被线程"+threadInfo.getLockOwnerName()+"持有");
            }
        }
    }
}
