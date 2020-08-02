package com.hs.thread.$4;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 15:29
 * @email husheng3921@163.com
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        //不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        //不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyRunner");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        //休眠5秒钟，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread interrupted is "+ sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is "+ busyThread.isInterrupted());
        //防止sleepThread 和busythread 立刻退出
        SleepUtils.second(2);

    }
    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){

            }
        }
    }
}
