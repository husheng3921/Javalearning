package com.hs.thread.$4;

import jdk.nashorn.internal.runtime.regexp.joni.constants.TargetInfo;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 15:50
 * @email husheng3921@163.com
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }
    static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Count i = " + i);
        }
        public void cancel(){
            on = false;
        }
    }
}
