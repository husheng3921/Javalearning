package com.hs.thread;

/**
 * Created by husheng02.
 * 在一个线程中调用other.join()，这时候当前线程会让出执行权给other线程，直到other线程执行完或者过了超时时间再继续执行当前线程
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 18:26
 */
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            for (int i = 1; i < 6; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程睡眠："+i+"秒");
            }
        });
        thread.start();
        thread.join(2000);
        for (int i = 1; i < 4; i++){
            Thread.sleep(1000);
            System.out.println("主线程睡眠："+i+"秒");
        }
    }
}
