package com.hs.thread.communication.threadlocal;

import java.util.Date;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 19:12
 * @email husheng3921@163.com
 */
public class ThreadB1 extends Thread {
    @Override
    public void run() {
        try{
            for(int i = 0; i <20; i++){
                if (Tools1.t1.get() == null){
                    Tools1.t1.set(new Date());
                }

                System.out.println("ThreadB get Value=" + Tools1.t1.get().getTime());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
