package com.hs.thread.communication.wait.comsummer.$2;


/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 17:33
 * @email husheng3921@163.com
 */
public class ThreadP extends Thread {
    public ThreadP(P p) {
        this.p = p;
    }

    private P p;

    @Override
    public void run() {
        while (true){
            p.setValue();
        }
    }
}
