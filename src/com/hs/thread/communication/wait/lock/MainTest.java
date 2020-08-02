package com.hs.thread.communication.wait.lock;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:34
 * @email husheng3921@163.com
 */
public class MainTest {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();
        ThreadB threadB = new ThreadB(lock);
        threadB.start();
    }
}
