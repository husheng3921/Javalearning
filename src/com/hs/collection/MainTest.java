package com.hs.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainTest {

    public static void main(String[] args) {
        //Coll
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new Hashtable<>();
        List<Integer> list = new CopyOnWriteArrayList<>();
        List<Integer> list1 = new ArrayList<>();
    }
}
