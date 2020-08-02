package com.hs.thread.communication.wait.comsummer;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 17:33
 * @email husheng3921@163.com
 */
public class ThreadC extends Thread {
    public ThreadC(C p) {
        this.c = p;
    }

    private C c;

    @Override
    public void run() {
        while (true){
            c.getValue();
        }
    }
}
