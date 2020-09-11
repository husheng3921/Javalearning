package com.hs.thread.stop;

import com.hs.thread.communication.wait.action.Run;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/31/0031 8:36
 * @email husheng3921@163.com
 */
public class StopDuringSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable run = () ->{
            int num = 0;
            try{
                while (!Thread.currentThread().isInterrupted() && num < 1000){
                    System.out.println(num++);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){

               //Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(run);
        thread.start();
        thread.sleep(5);
        thread.interrupt();
    }
}
