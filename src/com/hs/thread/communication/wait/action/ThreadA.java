package com.hs.thread.communication.wait.action;

import com.hs.thread.communication.wait.pipe.ThreadWrite;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:22
 * @email husheng3921@163.com
 */
public class ThreadA extends Thread {
    private DBTools dbTools;

    public ThreadA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}
