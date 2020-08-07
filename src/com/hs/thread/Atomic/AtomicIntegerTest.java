package com.hs.thread.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 16:27
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);
    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());//1
        System.out.println(ai.get());//2
    }
}
