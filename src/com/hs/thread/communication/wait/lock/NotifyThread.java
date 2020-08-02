package com.hs.thread.communication.wait.lock;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:33
 * @email husheng3921@163.com
 */
public class NotifyThread extends Thread{
    Object lock;

    public NotifyThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
       synchronized (lock){
           //lock.notify();//随机通知一个
           lock.notifyAll();//通知全部
       }
    }
}
