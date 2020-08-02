package com.hs.thread.singleton;

/**
 * TODO
 *  懒汉式立即加载,线程不安全,解决方案2
 * @author hushe
 * @date 2020/7/16/0016 14:32
 * @email husheng3921@163.com
 */
public class SingleTonTest22 {
    private static SingleTonTest22 instance ;

    private SingleTonTest22(){
        //private,防止类外直接new
    }

    /**
     * 同步代码块，和限定方法效果一样
     * @return
     */
    public  static SingleTonTest22 getInstance() {
        synchronized (SingleTonTest22.class){

        if (instance == null){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleTonTest22();
        }

        }
        return instance;
    }

}
