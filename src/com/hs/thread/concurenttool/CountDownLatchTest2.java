package com.hs.thread.concurenttool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 18:39
 */
public class CountDownLatchTest2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("所有运动员有5秒的准备时间");
        CountDownLatch c = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i< 5; i++){
            final int no = i +1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println( no +"号远动员准备完毕，等待");
                    try{
                        //调用await()方法开始等待
                        c.await();
                        System.out.println(no+"号远动员开始跑");
                    }catch (InterruptedException e){

                    }
                }
            };
            service.execute(runnable);
        }
        Thread.sleep(5000);
        System.out.println("5秒准备时间已经过去，发令枪响");
        //调用countDown方法，之前await被唤醒
        c.countDown();
        service.shutdown();
    }
}
