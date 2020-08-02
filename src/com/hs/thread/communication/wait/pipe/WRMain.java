package com.hs.thread.communication.wait.pipe;

import com.hs.thread.communication.wait.comsummer.$2.P;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:05
 * @email husheng3921@163.com
 */
public class WRMain {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();

            //in.connect(out);
            out.connect(in);

            ThreadRead tr = new ThreadRead(readData, in);
            tr.start();
            Thread.sleep(2000);
            ThreadWrite tw = new ThreadWrite(writeData,out);
            tw.start();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
