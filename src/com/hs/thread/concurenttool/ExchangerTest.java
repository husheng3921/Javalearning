package com.hs.thread.concurenttool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by husheng02.
 * Exchange用于进程间的数据交换，它提供一个同步点，两个线程可以交换彼此的数据，通过exchange方法交换数据
 * 如果第一个线程先执行exchange(),它会一直等待第二个线程也执行exchange方法，当两个线程都同时都到达同步点，就可以
 * 交换数据，将本线程产生出来的数据传递给对方。
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 15:20
 */
public class ExchangerTest {
    private static final Exchanger<String> exgre = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String A = "银行流水A";
                    exgre.exchange(A);
                }catch (InterruptedException e){

                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                try {
                    Thread.sleep(5000);
                    String A = exgre.exchange(B);
                    System.out.printf("A和B数据是否一致" + A.equals(B)+",A录入的是"+ A+",B录入的是"+B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
