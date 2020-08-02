package com.hs.thread.communication.wait;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:57
 * @email husheng3921@163.com
 */
public class Mythread1 extends Thread{
    private Object lock;

    public Mythread1(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                System.out.println("开始     wait time="+ System.currentTimeMillis());
                lock.wait();
                System.out.println("结束     wait time="+ System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
