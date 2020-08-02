package com.hs.annoation;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/25/0025 21:23
 * @email husheng3921@163.com
 */
public class Demo {
    @Company(name = "ali",status = "RUNNING", location = "hz")
    public void companyInfo(){}

    @Country("中国")
    public void method(){}
}
