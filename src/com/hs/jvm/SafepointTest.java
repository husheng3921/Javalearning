package com.hs.jvm;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/01 10:12
 */
public class SafepointTest {
    static double sum = 0;
    public static void foo(){
        for (int i = 0; i < 0x777777; i++){
            sum += Math.sqrt(i);
        }
    }
    public static void bar(){
        for(int i = 0; i < 50_000_000; i++){
            new Object().hashCode();
        }
    }

    public static void main(String[] args) {
        new Thread(SafepointTest::foo).start();
        new Thread(SafepointTest::bar).start();
    }
}
