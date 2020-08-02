package com.hs.thread.communication.wait.lock;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:32
 * @email husheng3921@163.com
 */
public class Service {
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("wait begin"+Thread.currentThread().getName());
                lock.wait();//会自动释放锁
                //Thread.sleep(1000);//不会释放锁
                System.out.println("wait end"+ Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("出现异常，wait状态，被interrupt");
        }

    }
}
