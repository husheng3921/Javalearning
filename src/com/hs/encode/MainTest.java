package com.hs.encode;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * java字符编码
 * https://blog.csdn.net/nlznlz/article/details/80950596
 */
public class MainTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
     try{
         System.out.println(System.getProperty("file.encoding"));
         FileReader fr = new FileReader(new File("test.txt"));
         System.out.println((char) fr.read());
         fr.close();
     }catch (FileNotFoundException e){
         e.printStackTrace();
     }catch (IOException e){
         e.printStackTrace();
     }
        String str = "a";
        System.out.println(str.getBytes("UTF-8").length);
        String str2 = "山";
        System.out.println(str2.getBytes("UTF-8").length);
        System.out.println(str.getBytes("UTF-16").length);
        byte[] bs2 = str2.getBytes("UTF-16");
        for(byte b:bs2) {
            System.out.print(Integer.toHexString((int)b)+" ");
        }
        System.out.println(str2.getBytes("UTF-16").length);
        str2 = "中国";
        System.out.println(str2.getBytes("UTF-16").length);
        Charset charset = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = charset.encode(str);
        System.out.println(byteBuffer);
        CharBuffer charBuffer = charset.decode(byteBuffer);
        System.out.println(charBuffer);
        encode();
    }

    /**
     *
     */
    private static void encode(){
        String name = "I am 君山";
        String test = "费孝通";
        char cc = '我';
        System.out.println((int)cc);
        System.out.println('\u541b');
        toHex(name.toCharArray());
        //System.out.println(Integer.toHexString());
        try {
            byte[] iso8859 = name.getBytes("ISO-8859-1");
            toHex(iso8859);
            byte[] gb2312 = name.getBytes("GB2312");
            toHex(gb2312);
            byte[] gbk = name.getBytes("GBK");
            toHex(gbk);
            byte[] utf16 = name.getBytes("UTF-16");
            toHex(utf16);
            byte[] utf8 = test.getBytes("UTF-8");
            toHex(utf8);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param chars
     */
    private static void toHex(char[] chars){
        for(char c:chars){

            System.out.print((int)c+"-"+Integer.toHexString((int)c)+" ");
        }
        System.out.println();

    }
    private static void toHex(byte[] bytes){
        for(byte b:bytes){
            System.out.print((int)b+"-"+Integer.toHexString((int)b)+" ");
        }
        System.out.println();
    }
}
