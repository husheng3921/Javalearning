package com.hs.thread.communication.threadlocal;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 19:15
 * @email husheng3921@163.com
 */
public class Run {
    public static void main(String[] args) {
        try{
            ThreadA1 a = new ThreadA1();
            ThreadB1 b = new ThreadB1();
            a.start();
            Thread.sleep(1000);
            b.start();
            /*for (int i = 0; i < 100; i++){
                Tools.t1.set("Main"+(i+1));
                System.out.println("Main get Value="+ Tools.t1.get());
                Thread.sleep(200);
            }*/
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
