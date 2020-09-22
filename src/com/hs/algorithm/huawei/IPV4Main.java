package com.hs.algorithm.huawei;

import java.util.Scanner;

/**
 * Created by husheng02.
 * IPV4合法
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/19 15:30
 */
public class IPV4Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipv4 = scanner.nextLine();
        System.out.println(isIPV4(ipv4));
    }
    public static boolean isIPV4(String ipv4){
        if (ipv4 == null || ipv4.length() == 0){
            return false;
        }
        //.分割
        String[] parts = ipv4.split("\\.");
        //组成为4部分，
        if (parts.length != 4){
            return false;
        }
        //循环判断各个数字0-255范围
        for (String part : parts ){
            //0..2.3
            if(part.length() == 0){
                return false;
            }
            //02.0.3.6
            if (part.charAt(0) == '0' && part.length() > 1){
                return false;
            }
            try{
                int n = Integer.parseInt(part);
                if(n < 0 || n > 255){
                    return false;
                }
            }catch (NumberFormatException e){
                return false;
            }

        }
        return true;
    }
}
