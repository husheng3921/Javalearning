package com.hs.annoation;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/25/0025 21:34
 * @email husheng3921@163.com
 */
public class AnnotationProcessor {
    public static void main(String[] args) {
        Class demoClazz = Demo.class;
        for (Method method:demoClazz.getMethods()){
            Company companyAn = (Company) method.getAnnotation(Company.class);
            if (companyAn != null){
                System.out.println("method name" + method.getName());
                System.out.println("name" + companyAn.name());
                System.out.println("Status" + companyAn.status());
            }
        }
    }
}
