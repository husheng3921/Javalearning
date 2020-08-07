package com.hs.thread.concurenttool;

/**
 * Created by husheng02.
 * join用于让当前线程等待join线程执行结束，其原理就是不停检查join线程是否存活
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 16:16
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        });
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("all thread finish");
    }
}
