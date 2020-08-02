package com.hs.thread.communication.wait.comsummer.$2;

import com.hs.thread.communication.wait.comsummer.ValueObject;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 17:27
 * @email husheng3921@163.com
 */
public class P {

    private String lock;

    public P(String lock) {
        this.lock = lock;
    }
    public void setValue(){
        try {
            synchronized (lock){
                if (!ValueObject.value.equals("")){
                    System.out.println("生产者"+Thread.currentThread().getName()+"WAITING 了 @");
                    lock.wait();//不为空则阻塞
                }
                System.out.println("生产者"+Thread.currentThread().getName()+"RUNABLE 了 #");
                String value = System.currentTimeMillis() + "_"+System.nanoTime();
                //System.out.println("set值是"+ value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
