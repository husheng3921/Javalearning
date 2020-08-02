package com.hs.thread.communication.wait.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 17:59
 * @email husheng3921@163.com
 */
public class ReadData {
    public void readMethod(PipedInputStream in){
        try{
            System.out.println("read: ");
            byte[] byteArray = new byte[20];
            int readLength = in.read(byteArray);
            while (readLength != -1){
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = in.read(byteArray);
            }
            System.out.println();
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
