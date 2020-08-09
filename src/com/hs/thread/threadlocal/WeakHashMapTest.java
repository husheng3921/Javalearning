package com.hs.thread.threadlocal;

import java.util.WeakHashMap;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 16:15
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        House seller1 = new House();
        SellerInfo sellerInfo1 = new SellerInfo();

        House seller2 = new House();
        SellerInfo sellerInfo2 = new SellerInfo();

        WeakHashMap<House, SellerInfo> weakHashMap = new WeakHashMap<>();
        weakHashMap.put(seller1, sellerInfo1);
        weakHashMap.put(seller2, sellerInfo2);
        System.out.println("WeakHashMap before null ,size = " + weakHashMap.size());
        seller1 = null;
        System.gc();
        System.runFinalization();
        System.out.println("WeakHashMap after null ,size = " + weakHashMap.size());
        System.out.println(weakHashMap);
    }
}
class SellerInfo {

}
