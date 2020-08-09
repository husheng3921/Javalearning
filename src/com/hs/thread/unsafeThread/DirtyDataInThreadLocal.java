package com.hs.thread.unsafeThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 15:24
 */
public class DirtyDataInThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(1);
        for (int i = 0; i <2; i++){
            pool.execute(new Mythread());
        }
    }
    private static class Mythread extends Thread{
        private static boolean flag = true;

        @Override
        public void run() {
            if(flag){
                //第1个线程set，并没有进行remove
                //而第二个线程由于某种原因没有进行set操作
                threadLocal.set(this.getName()+", session info");
                flag = false;
            }
            System.out.println(this.getName() + "线程是"+ threadLocal.get());
            //threadLocal.remove();
            //flag = true;
        }
    }
}
