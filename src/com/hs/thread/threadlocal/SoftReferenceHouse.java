package com.hs.thread.threadlocal;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 15:47
 */
public class SoftReferenceHouse {
    public static void main(String[] args) {
        List<SoftReference> house = new ArrayList<>();
        int i = 0;
        while (true){
            SoftReference<House> buyer2 = new SoftReference<>(new House());
            house.add(buyer2);
            System.out.println("i="+ (++i));
        }
    }

}
class House{
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];
    class Door{}
}