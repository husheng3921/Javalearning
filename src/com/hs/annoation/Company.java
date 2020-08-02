package com.hs.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/25/0025 21:19
 * @email husheng3921@163.com
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Company {
    public enum Status {RUNNING, CLOSED};
    String name() default "NETEASE";//默认值
    String status() default "RUNNING";
    String location();//没有默认值
}
