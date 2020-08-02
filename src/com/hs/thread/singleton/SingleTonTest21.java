package com.hs.thread.singleton;

/**
 * TODO
 *  懒汉式立即加载,线程不安全,解决方案1
 * @author hushe
 * @date 2020/7/16/0016 14:32
 * @email husheng3921@163.com
 */
public class SingleTonTest21 {
    private static SingleTonTest21 instance ;

    private SingleTonTest21(){
        //private,防止类外直接new
    }

    /**
     * 设置同步方法效率太低了，整个方法上锁
     * @return
     */
    public synchronized static SingleTonTest21 getInstance() {
        if (instance == null){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleTonTest21();
        }
        return instance;
    }

}
