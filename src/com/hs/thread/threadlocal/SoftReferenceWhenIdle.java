package com.hs.thread.threadlocal;

import java.lang.ref.SoftReference;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 16:22
 */
public class SoftReferenceWhenIdle {
    public static void main(String[] args) {
        House seller = new House();
        SoftReference<House> buyer2 = new SoftReference<>(seller);
        seller = null;
        while (true){
            //建议JVM进行垃圾回收
            System.gc();
            System.runFinalization();
            if (buyer2.get() == null){
                System.out.println("house is null");
                break;
            }else{
                System.out.println("house is still there");
            }
        }
    }
}
