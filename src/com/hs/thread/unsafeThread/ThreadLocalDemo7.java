package com.hs.thread.unsafeThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 14:47
 */
public class ThreadLocalDemo7 {
    public static void main(String[] args) {


        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 16; i++){
            final int I = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    new Service1().service1("whu "+I);
                }
            });
        }
        threadPool.shutdown();
    }
}
