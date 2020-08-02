package com.hs.thread.$4;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 17:07
 * @email husheng3921@163.com
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + "terminate.");
    }
    static class Domino implements Runnable{
        private Thread thread;
        public Domino (Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try{
                thread.join();
            }catch ( InterruptedException e){

            }
            System.out.println(Thread.currentThread().getName() + "terminate.");
        }
    }
}
