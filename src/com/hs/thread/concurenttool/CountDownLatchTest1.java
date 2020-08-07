package com.hs.thread.concurenttool;

import java.util.concurrent.CountDownLatch;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 15:48
 */
public class CountDownLatchTest1 {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
                c.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();
        System.out.println("3");
    }

}
