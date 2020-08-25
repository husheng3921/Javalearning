package com.hs.test.$1;

import java.util.Scanner;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/24 21:55
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int len = strs.length;
        System.out.println(strs[len-1].length());
    }
}
