package com.hs.thread.communication.threadlocal;

/**
 * TODO
 * ThreadLocal解决每个线程绑定自己的值
 * @author hushe
 * @date 2020/7/16/0016 19:10
 * @email husheng3921@163.com
 */
public class RunTest1 {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        if (t1.get() == null){
            System.out.println("从未反过值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
