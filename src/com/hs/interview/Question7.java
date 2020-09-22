package com.hs.interview;

import java.util.Arrays;
import java.util.Vector;


/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 9:38
 */
public class Question7 {
    public static void main(String[] args) {
        //误区1：：Vector不是collection
        //误区2： ConcurrentModificationException不会在线程安全集合中出现
        Vector<Integer> values = new Vector<Integer>(Arrays.asList(1,2,3));
        remvoe(values);
        System.out.println(values);
        /**
         * java[1.0,1.5]集合框架设计Fast-fail
         *
         */
    }

    private static void remvoe(Vector<Integer> values) {
        for (Object value:values){
            values.remove(value);
        }
    }
}
