package com.hs.thread.communication.wait;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 15:50
 * @email husheng3921@163.com
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String newStr = new String("");
            newStr.wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    /**
     * 抛出异常java.lang.IllegalMonitorStateException
     * 没有对象监视器，也就是没有同步加锁
     */
}
