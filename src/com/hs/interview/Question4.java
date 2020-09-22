package com.hs.interview;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 9:25
 */
public class Question4 {
    public static void main(String[] args) {
        boolean flag= true;
        try{
            if(flag){
                while (true){

                }
            }else{
                System.exit(1);
                //finally除了JVM退出，都会执行
            }
        }finally {
            //无论如何flag为何值，都不执行
            System.out.println("In finally");
        }
    }
}
