package com.hs.pattern.callback;

/**
 * TODO
 *
 *
 * @author hushe
 * @date 2020/7/23/0023 9:45
 * @email husheng3921@163.com
 */
public class BClass {
    public void process(ICallBack callBack){//B类的函数P
        callBack.methodToCallback();//回调函数F
    }
}
