package com.hs.thread.ABC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/15 11:28
 */
public class ABCLock {
    private static Lock lock = new ReentrantLock();
    private static volatile int state = 0;
    static class ThreadA extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10;){
                try {
                    lock.lock();
                    while (state % 3 == 0){
                        System.out.println("A");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10;){
                try {
                    lock.lock();
                    while (state % 3 == 1){
                        System.out.println("B");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    static class ThreadC extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 10;){
                try {
                    lock.lock();
                    while (state % 3 == 2){
                        System.out.println("C");
                        state++;
                        i++;
                    }
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
