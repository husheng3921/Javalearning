package com.hs.thread.singleton;

/**
 * TODO
 *  饿汉式立即加载,线程安全
 * @author hushe
 * @date 2020/7/16/0016 14:32
 * @email husheng3921@163.com
 */
public class SingleTonTest1 {
    private static SingleTonTest1 instance = new SingleTonTest1();

    private SingleTonTest1(){
        //private,防止类外直接new
    }

    public static SingleTonTest1 getInstance(){
        /**
         * 此代码版本立即加载
         * 缺点是不能有其他实例变量
         * getInstance()方法没有同步
         * 所以有可能出现线程安全问题
         */
        return instance;
    }

}
