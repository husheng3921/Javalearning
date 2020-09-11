package com.hs;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * look in "c:\\user"
 */
public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String, Integer> map = new HashMap<>();
        map.put("husheng", 26);
        map.put("hh", 30);
        String jk = "hhh";

        List<String> lists = new ArrayList<>();
        lists.add("a");
        lists.add("b");
        lists.add("c");
        lists.add("d");
        lists.add("e");
        lists.add("f");
        for( int i = 0; i < lists.size(); i++){
            lists.remove(i);
            System.out.println("remove");
            System.out.println(lists.size());
        }
        System.out.println("size="+lists.size());
        Map<User, String> maps = new HashMap<>();
        User user1 = new User(1, "hh");
        User user2 = new User(1, "hh");
        maps.put(user1,"hh");
        maps.put(user2, "hh");
        Map<String, String> map2 = new ConcurrentHashMap<>();

        System.out.println(maps.size());
<<<<<<< HEAD
        Set<Integer> set = new HashSet<>();
        set.add(1);
        boolean res = set.add(1);
        System.out.println(res);
=======

        Integer aa = 30;
        Integer bb = 30;
        System.out.println(aa == bb);
        String s1 = "33";
>>>>>>> ba1d6b756879e4567439f92fff06ea3b3503863d

    }
}
