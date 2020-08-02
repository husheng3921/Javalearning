package com.hs.thread.communication.wait;

import javax.sound.midi.Soundbank;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:04
 * @email husheng3921@163.com
 */
public class ThreadA extends Thread{
    private Object lock;
    private MyList list;

    public ThreadA(Object lock, MyList list) {
        super();
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                if (list.size() != 5){
                    System.out.println("wait begin:"+ System.currentTimeMillis());
                    lock.wait();//阻塞当前线程，阻塞队列， 同时释放锁
                    System.out.println("wait end:"+ System.currentTimeMillis());
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
