package com.hs.thread.communication.wait.comsummer;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 17:35
 * @email husheng3921@163.com
 */
public class PCmain {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP tp = new ThreadP(p);
        ThreadC tc = new ThreadC(c);
        tp.start();
        tc.start();
    }
}
