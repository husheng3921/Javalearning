package com.hs.thread.$4;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 15:22
 * @email husheng3921@163.com
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            try{
                SleepUtils.second(10);

            }finally {
                System.out.println("DaemonThread finally run");
            }
        }
    }
}
