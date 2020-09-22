package com.hs.thread.ABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/15 11:35
 */
public class ABCCondition {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 0;
    static class ThreadA extends Thread{
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i< 10; i++){
                    while (count % 3 != 0){
                        A.await();//一直阻塞
                    }
                    System.out.println("A");
                    count++;
                    B.signal();//唤醒B线程
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    static class ThreadB extends Thread{
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i< 10; i++){
                    while (count % 3 != 1){
                        B.await();//一直阻塞
                    }
                    System.out.println("B");
                    count++;
                    C.signal();//唤醒B线程
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    static class ThreadC extends Thread{
        @Override
        public void run() {
            try{
                lock.lock();
                for (int i = 0; i< 10; i++){
                    while (count % 3 != 2){
                        C.await();//一直阻塞
                    }
                    System.out.println("C");
                    count++;
                    A.signal();//唤醒B线程
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
