package com.hs.thread.communication.join;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:58
 * @email husheng3921@163.com
 */
public class ThreadB extends Thread{
    @Override
    public void run() {
        System.out.println("b run begin time: "+System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b run end time: "+System.currentTimeMillis());
    }
    public synchronized void bService(){
        System.out.println("打印了 BService timer"+ System.currentTimeMillis());
    }
}
