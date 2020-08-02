package com.hs.thread.communication.wait;

import com.hs.thread.exception.Mythread;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:50
 * @email husheng3921@163.com
 */
public class Test3 {
    public static void main(String[] args) {
        try {
          Object lock = new Object();
            Mythread1 t1 = new Mythread1(lock);
            t1.start();
            Thread.sleep(1000);
            Mythread2 t2 = new Mythread2(lock);
            t2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    /**
     * 抛出异常java.lang.IllegalMonitorStateException
     * 没有对象监视器，也就是没有同步加锁
     */
}
