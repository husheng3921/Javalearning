package com.hs.thread.singleton;

/**
 * TODO
 * 使用静态内部类实现单例模式
 * @author hushe
 * @date 2020/7/16/0016 14:55
 * @email husheng3921@163.com
 */
public class SingleTonTest3 {
    private static class ObjectHandler{
        private static SingleTonTest3 instance = new SingleTonTest3();
    }
    private SingleTonTest3(){

    }
    public static SingleTonTest3 getInstance(){
        return ObjectHandler.instance;
    }
}
