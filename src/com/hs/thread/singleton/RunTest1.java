package com.hs.thread.singleton;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 14:36
 * @email husheng3921@163.com
 */
public class RunTest1 {
    private static class Mythread extends Thread{
        @Override
        public void run() {
            //System.out.println(SingleTonTest1.getInstance().hashCode());
            //System.out.println(SingleTonTest2.getInstance().hashCode());//多例
            //System.out.println(SingleTonTest21.getInstance().hashCode());//synchronized限定方法
            //System.out.println(SingleTonTest22.getInstance().hashCode());//synchronized限定类
            //System.out.println(SingleTonTest23.getInstance().hashCode());//synchronized限定重要代码块，不安全
            System.out.println("Test24-"+SingleTonTest24.getInstance().hashCode());//synchronized双重检测，安全
            System.out.println("Test3-"+SingleTonTest3.getInstance().hashCode());//静态内部类，安全
            System.out.println("Test4-"+SingleTonTest4.getInstance().hashCode());//静态代码块初始类，安全
            System.out.println("Test5-"+SingleTonTest5.INSTANCE.hashCode());//枚举类，安全
        }
    }

    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        Mythread t2 = new Mythread();
        Mythread t3 = new Mythread();
        t1.start();
        t2.start();
        t3.start();
    }
}
