package com.hs.thread.communication.wait.pipe;


import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:02
 * @email husheng3921@163.com
 */
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream in;

    public ThreadRead(ReadData read, PipedInputStream in) {
        this.read = read;
        this.in = in;
    }

    @Override
    public void run() {
        read.readMethod(in);
    }
}
