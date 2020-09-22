package com.hs.interview;

import java.lang.reflect.Field;

/**
 * Created by husheng02.
 * String是否是线程安全的，为什么
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 9:49
 */
public class Question9 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s ="abc";
        //反射修改
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] value = (char[]) field.get(s);
        value[0] ='d';
        System.out.println(s);
        // String#hashCode()，无final和volatile修饰
    }
}
