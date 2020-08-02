package com.hs.thread.exception;

/**
 * TODO
 * 运行空指针，线程抛出异常,setUncaughtExceptionHandler()对指定的线程对象设置默认的异常处理器
 * @author hushe
 * @date 2020/7/16/0016 15:27
 * @email husheng3921@163.com
 */
public class MainTest2 {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        t1.setName("线程1");
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程："+ t.getName()+"出现了异常");
                e.printStackTrace();
            }
        });
        t1.start();
        Mythread t2 = new Mythread();
        t2.setName("线程t2");
        t2.start();
    }
}
