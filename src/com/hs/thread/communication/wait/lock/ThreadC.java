package com.hs.thread.communication.wait.lock;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:33
 * @email husheng3921@163.com
 */
public class ThreadC extends Thread{
    Object lock;

    public ThreadC(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
