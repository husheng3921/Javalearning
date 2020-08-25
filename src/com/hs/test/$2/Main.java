package com.hs.test.$2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/24 21:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String tagert = scanner.nextLine().toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){

            int num = map.getOrDefault(str.charAt(i),0);
            map.put(str.charAt(i), num+1);
        }
        System.out.println(map.getOrDefault(tagert.charAt(0),0));
    }
}
