package com.hs.thread.ABC;

import java.util.concurrent.Semaphore;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/15 11:43
 */
public class ABCSemaphore {
    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    static class ThreadA extends Thread{
        @Override
        public void run() {
            try{
                for (int i = 0; i< 10; i++){
                    A.acquire();
                    System.out.println("A");
                    B.release();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            try{
                for (int i = 0; i< 10; i++){
                    B.acquire();
                    System.out.println("B");
                    C.release();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    static class ThreadC extends Thread{
        @Override
        public void run() {
            try{
                for (int i = 0; i< 10; i++){
                   C.acquire();
                    System.out.println("C");
                   A.release();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
