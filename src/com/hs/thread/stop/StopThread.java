package com.hs.thread.stop;

/**
 * TODO
 * 线程错误的停止方法
 * stop(),suspend(),resume(),已经被丢弃
 * 1.stop()会直接把线程停止，这样就没给线程足够时间来处理
 * 想要在停止前保存数据的逻辑，会导致数据完整性等问题。
 * interupte()会标中断线程
 * interrupted()会返回true，同时清除中断标记(true)，第二次调用时返回false
 * isInterrupted()会返回中断状态，不会清除中断标记(false)
 * @author hushe
 * @date 2020/7/31/0031 8:30
 * @email husheng3921@163.com
 */
public class StopThread implements Runnable{
    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000){
            System.out.println("count = "+ count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        thread.sleep(5);
        thread.interrupt();
    }
}
