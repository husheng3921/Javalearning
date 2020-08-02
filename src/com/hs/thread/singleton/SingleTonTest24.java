package com.hs.thread.singleton;

/**
 * TODO
 *  懒汉式立即加载,线程不安全,解决方案4，双重检测锁机制
 * @author hushe
 * @date 2020/7/16/0016 14:32
 * @email husheng3921@163.com
 */
public class SingleTonTest24 {
    private static SingleTonTest24 instance ;

    private SingleTonTest24(){
        //private,防止类外直接new
    }

    /**
     * 同步代码块，和限定方法效果一样
     * @return
     */
    public  static SingleTonTest24 getInstance() {
        if (instance == null){
            /** 同步重要的代码块
             *  虽然部分代码被锁上还是有线程安全问题
             *  即两个线程同时进入此部分后，线程A获取锁，创建实例，B随后继续创建实例
             *  所以在需要加双重判断
             */
            synchronized (SingleTonTest24.class){
                if (instance == null){
                    instance = new SingleTonTest24();
                }

            }
        }

        return instance;
    }

}
