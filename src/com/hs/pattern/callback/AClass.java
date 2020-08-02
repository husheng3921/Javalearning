package com.hs.pattern.callback;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/23/0023 9:46
 * @email husheng3921@163.com
 */
public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();//
        //A类调用B类的P函数Process
        b.process(new ICallBack() {
            @Override
            public void methodToCallback() {//B类反过来调用回调函数F
                System.out.println("Call back me");
            }
        });
    }
}
