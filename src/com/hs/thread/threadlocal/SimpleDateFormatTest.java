package com.hs.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/01 15:26
 */
public class SimpleDateFormatTest {
    static ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(local.get().parse("2020-09-01 11:12:56"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }finally {
                        local.remove();
                    }
                }
            });
            thread.start();
        }
    }
}
