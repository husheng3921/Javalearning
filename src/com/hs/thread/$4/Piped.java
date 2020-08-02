package com.hs.thread.$4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 16:58
 * @email husheng3921@163.com
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //将输出流和输入流进行连接，否则使用时会抛出IOException
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read())!= -1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }
    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int recevice = 0;
            try{
                while ((recevice = in.read() ) != -1){
                    System.out.print((char) recevice);
                }
            }catch (IOException e){

            }
        }
    }
}
