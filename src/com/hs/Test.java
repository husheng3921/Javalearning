package com.hs;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/16/0016 11:09
 * @email husheng3921@163.com
 */
public class Test {
    public static void main(String[] args) {
       /* int j = 0;
        for (int i = 0; i < 100; i++){
            j = j++;
        }
        System.out.println(j);
        */
        /*int a = '-' -'0';
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);*/
        Thread t = new Thread(){
            @Override
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.println(22);

    }
    public int strToInt(String str){
        String noTrimStr = str.trim();//去掉首尾空格
        int flag = 1;//符号
        if (noTrimStr.charAt(0) == '-'){
            flag = -1;
        }

        return 10;
    }
    static void pong(){
        System.out.println("信用卡");
    }
}
