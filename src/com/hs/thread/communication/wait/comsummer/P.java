package com.hs.thread.communication.wait.comsummer;

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
                    lock.wait();//不为空则阻塞
                }
                String value = System.currentTimeMillis() + "_"+System.nanoTime();
                System.out.println("set值是"+ value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
