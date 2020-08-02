package com.hs.thread.communication.join;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:58
 * @email husheng3921@163.com
 */
public class ThreadA extends Thread{
    private ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        try{
            synchronized (b){
                b.start();
                //Thread.sleep(6000);
                b.join();//说明join释放锁
                for (int i = 0; i<Integer.MAX_VALUE;i++){
                    String newStr = new String();
                    Math.random();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
