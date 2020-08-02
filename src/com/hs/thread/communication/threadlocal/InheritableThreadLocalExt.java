package com.hs.thread.communication.threadlocal;

import java.util.Date;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 19:25
 * @email husheng3921@163.com
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue+"子线程我家的";
    }
}
