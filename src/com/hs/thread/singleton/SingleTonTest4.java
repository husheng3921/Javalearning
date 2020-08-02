package com.hs.thread.singleton;

/**
 * TODO
 *  静态代码块,安全
 * @author hushe
 * @date 2020/7/16/0016 14:32
 * @email husheng3921@163.com
 */
public class SingleTonTest4 {
    private static SingleTonTest4 instance;

    private SingleTonTest4(){
        //private,防止类外直接new
    }
    static {
        instance = new SingleTonTest4();
    }
    public static SingleTonTest4 getInstance(){
        return instance;
    }

}
