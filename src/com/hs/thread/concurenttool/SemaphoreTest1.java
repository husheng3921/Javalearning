package com.hs.thread.concurenttool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by husheng02.
 * Semaphore信号量用来控制同时访问特定资源的线程数量，它通过协调各个线程，保证合理使用公共资源acquire(),release();
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 15:39
 */
public class SemaphoreTest1 {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static ExecutorService threadPool2 = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for(int i = 0; i < THREAD_COUNT; i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        s.acquire();
                    }catch (InterruptedException e){

                    }
                    System.out.println(Thread.currentThread().getName()+"拿到了许可证，花费2秒执行慢事务");
                    try{
                       Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("慢服务执行完毕"+Thread.currentThread().getName());
                    s.release();
                }
            });
            threadPool2.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        s.acquire();
                    }catch (InterruptedException e){

                    }
                    System.out.println(Thread.currentThread().getName()+"拿到了许可证，花费2秒执行慢事务");
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("慢服务执行完毕"+Thread.currentThread().getName());
                    s.release();
                }
            });
        }
        threadPool.shutdown();
        threadPool2.shutdown();
    }
}
