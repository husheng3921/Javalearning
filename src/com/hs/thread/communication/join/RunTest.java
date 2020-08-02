package com.hs.thread.communication.join;


/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 19:03
 * @email husheng3921@163.com
 */
public class RunTest {
    public static void main(String[] args) {
        ThreadB tb = new ThreadB();
        ThreadA ta = new ThreadA(tb);
        ta.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadC c = new ThreadC(tb);
        c.start();
    }
}
