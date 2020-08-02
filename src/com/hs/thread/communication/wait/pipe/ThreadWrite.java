package com.hs.thread.communication.wait.pipe;


import java.io.PipedOutputStream;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:02
 * @email husheng3921@163.com
 */
public class ThreadWrite extends Thread {
    private WriteData writeData;
    private PipedOutputStream out;

    public ThreadWrite(WriteData writeData, PipedOutputStream out) {
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
