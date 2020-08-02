package com.hs.thread.communication.wait.action;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:22
 * @email husheng3921@163.com
 */
public class ThreadB extends Thread {
    private DBTools dbTools;

    public ThreadB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
