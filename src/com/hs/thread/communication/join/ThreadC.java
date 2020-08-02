package com.hs.thread.communication.join;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:58
 * @email husheng3921@163.com
 */
public class ThreadC extends Thread{
    public ThreadC(ThreadB b) {
        this.b = b;
    }

    private ThreadB b;

    @Override
    public void run() {
        b.bService();
    }
}
