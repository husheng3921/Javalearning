package com.hs.thread.communication.join;

import com.hs.thread.communication.wait.pipe.ThreadWrite;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:28
 * @email husheng3921@163.com
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        try{
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
