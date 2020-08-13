package com.hs.thread.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/13 16:36
 */
public class UserThreadFactory implements ThreadFactory {
    private final String namePrifx;
    private final AtomicInteger nextId = new AtomicInteger(1);
    UserThreadFactory(String whatFeatureGroup){
        namePrifx = "UserThreadFacotry's" +whatFeatureGroup+ "-Worker-";
    }
    @Override
    public Thread newThread(Runnable r) {
        String name = namePrifx + nextId.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}
class Task implements Runnable{
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running _"+ count.getAndIncrement());
    }
}