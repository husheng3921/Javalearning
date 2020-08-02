package com.hs.thread.exception;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:26
 * @email husheng3921@163.com
 */
public class Mythread extends Thread {
    @Override
    public void run() {
        String userName = null;
        System.out.println(userName.hashCode());
    }
}
