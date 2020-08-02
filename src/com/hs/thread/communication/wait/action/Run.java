package com.hs.thread.communication.wait.action;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:24
 * @email husheng3921@163.com
 */
public class Run {
    public static void main(String[] args) {
        DBTools db = new DBTools();
        for (int i = 0; i < 20; i++){
            ThreadB tb = new ThreadB(db);
            tb.start();
            ThreadA ta = new ThreadA(db);
            ta.start();
        }
    }
}
