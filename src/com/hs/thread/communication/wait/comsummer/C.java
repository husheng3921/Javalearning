package com.hs.thread.communication.wait.comsummer;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 17:31
 * @email husheng3921@163.com
 */
public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }
    public void getValue(){
        try{
            synchronized (lock){
                if (ValueObject.value.equals("")){
                    lock.wait();//值为空无法消费等待
                }
                System.out.println("get的值是"+ValueObject.value);
                ValueObject.value = "";//消费置空
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
