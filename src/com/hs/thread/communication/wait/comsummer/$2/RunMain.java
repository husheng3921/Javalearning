package com.hs.thread.communication.wait.comsummer.$2;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 17:44
 * @email husheng3921@163.com
 */
public class RunMain {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP[] pt=new ThreadP[2];
        ThreadC[] ct = new ThreadC[2];
        for (int i = 0; i < 2; i++){
            pt[i] = new ThreadP(p);
            pt[i].setName("生产者："+ (i+1));
            ct[i] = new ThreadC(c);
            ct[i].setName("消费者"+(i+1));
            pt[i].start();
            ct[i].start();
        }
        Thread.sleep(5000);
        Thread[] tarra = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(tarra);
        for (int i = 0; i< tarra.length;i++){
            System.out.println(tarra[i].getName()+" "+tarra[i].getState());
        }
    }
}
