package com.hs.thread.singleton;

/**
 * TODO
 *  懒汉式立即加载,线程不安全
 * @author hushe
 * @date 2020/7/16/0016 14:32
 * @email husheng3921@163.com
 */
public class SingleTonTest2 {
    private static SingleTonTest2 instance ;

    private SingleTonTest2(){
        //private,防止类外直接new
    }

    public static SingleTonTest2 getInstance() {
        /**
         * 此代码版本立即加载
         * 缺点是不能有其他实例变量
         * getInstance()方法没有同步
         * 所以有可能出现线程安全问题
         */
        if (instance == null){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingleTonTest2();
        }
        return instance;
    }

}
