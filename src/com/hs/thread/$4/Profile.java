package com.hs.thread.$4;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 17:13
 * @email husheng3921@163.com
 */
public class Profile {
    private static final ThreadLocal<Long> TIME_THREADLOCAL =new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profile.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("cost" + Profile.end()+"mills");
    }
}
