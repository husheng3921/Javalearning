package com.hs.thread.exception;

/**
 * TODO
 * 运行空指针，线程抛出异常
 * @author hushe
 * @date 2020/7/16/0016 15:27
 * @email husheng3921@163.com
 */
public class MainTest1 {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        t1.start();
    }
}
