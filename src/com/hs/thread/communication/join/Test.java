package com.hs.thread.communication.join;


/**
 * TODO
 * 主线程创建并启动子线程，如果子线程要进行大量的耗时运算，主线程往往将早于子线程前结束；如果要
 * 主线程等待子线程执行完后再结束，需要用到join(),方法join()的作用就是等待线程对象销毁
 * @author hushe
 * @date 2020/7/16/0016 18:30
 * @email husheng3921@163.com
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThread th = new MyThread();
        th.start();
        th.join();
        System.out.println("我想当th对象执行完毕之后再执行");
        System.out.println("但上面的sleep()中的值应该写多少");
        System.out.println("答案不能确定");
    }
}
