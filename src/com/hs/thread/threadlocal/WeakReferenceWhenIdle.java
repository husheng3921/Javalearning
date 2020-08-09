package com.hs.thread.threadlocal;

import java.lang.ref.WeakReference;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 16:08
 */
public class WeakReferenceWhenIdle {
    public static void main(String[] args) {
        House seller = new House();
        WeakReference<House> buyer3 = new WeakReference<>(seller);
        seller = null;

        long start = System.nanoTime();
        int count = 0;
        while (true){
            if (buyer3.get() == null){
                long duration = (System.nanoTime() - start)/(1000*1000);
                System.out.println("house is null and exited time = " + duration +"ms");
                break;
            }else {
                System.out.println("still there. count = "+ (count++));
            }
        }
    }
}
