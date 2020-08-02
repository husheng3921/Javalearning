package com.hs.thread.communication.threadlocal;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 19:27
 * @email husheng3921@163.com
 */
public class Run2 {
    public static void main(String[] args) {
        try{
            for(int i = 0; i < 10; i++){
                System.out.println(" Main 线程中取值="+ Tools2.tl.get());
                Thread.sleep(100);
            }
            Thread.sleep(1000);
            ThreadA2 a2 = new ThreadA2();
            a2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
