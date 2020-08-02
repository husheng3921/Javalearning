package com.hs.thread.communication.wait;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:50
 * @email husheng3921@163.com
 */
public class TestAB {
    public static void main(String[] args) {
        MyList list = new MyList();
        try {
          Object lock = new Object();
            ThreadA t1 = new ThreadA(lock,list);
            t1.start();
            Thread.sleep(50);
            ThreadB t2 = new ThreadB(lock,list);
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
