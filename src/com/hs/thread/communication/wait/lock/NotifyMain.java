package com.hs.thread.communication.wait.lock;

import com.hs.algorithm.tree.$589.Node;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:34
 * @email husheng3921@163.com
 */
public class NotifyMain {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.start();
        ThreadC threadc = new ThreadC(lock);
        threadc.start();
        Thread.sleep(1000);
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
    }
}
