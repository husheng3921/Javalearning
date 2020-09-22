package com.hs.interview;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 9:17
 */
public class Question3 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = new String("abc");
        /**
         * *
         *      * @return  a string that has the same contents as this string, but is
         *      *          guaranteed to be from a pool of unique strings.
         */
        s2.intern();//   s2引用没有变化
        String s3 = s2.intern();
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//true
        /**
         * 变量，对象，引用
         * 变量：具部变量、成员变量(实例，static),Label标签(变量名称，变量类型，引用指向(强引用))
         * 对象：大多数情况是JAVA Heap堆，new 实例
         * 引用：强(!=null),软引用，
         */
    }
}
