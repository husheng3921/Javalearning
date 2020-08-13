package com.hs.thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/13 16:35
 */
public class UserThreadPool {
    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque(2);
        UserThreadFactory f1 = new UserThreadFactory("第1机房");
        UserThreadFactory f2 = new UserThreadFactory("第2机房");
        UserRejectHandler handler = new UserRejectHandler();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);

        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue,f2,handler);

        Runnable task = new Task();
        for (int i = 0; i < 200; i++){
            threadPoolExecutor.execute(task);
            threadPoolExecutor1.execute(task);
        }
    }
}
