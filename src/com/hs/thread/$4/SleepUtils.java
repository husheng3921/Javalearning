package com.hs.thread.$4;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 15:06
 * @email husheng3921@163.com
 */
public class SleepUtils {
    public static final void second(long seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){

        }
    }
}
