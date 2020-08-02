package com.hs.thread.communication.threadlocal;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 19:12
 * @email husheng3921@163.com
 */
public class ThreadA2 extends Thread {
    @Override
    public void run() {
        try{
            for(int i = 0; i <10; i++){
                //Tools2.tl.set("ThreadA "+(i+1));
                System.out.println("ThreadA get Value=" + Tools2.tl.get());
                Thread.sleep(200);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
