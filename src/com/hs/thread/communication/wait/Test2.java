package com.hs.thread.communication.wait;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:51
 * @email husheng3921@163.com
 */
public class Test2 {
    public static void main(String[] args) {
        try{
            String lock = new String("");
            System.out.println("syn上面");
            synchronized (lock){
                System.out.println("syn第一行");
                lock.wait();
                System.out.println("wait下面的代码");
            }
            System.out.println("syn下面的代码");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    /**
     * 执行到wait下面的代码就不执行了
     *
     */
}
