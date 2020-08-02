package com.hs.collection.map;

import java.util.*;

/**
 * TODO
 * Map中key 、key、key-value遍历
 * @author hushe
 * @date 2020/5/15/0015 9:43
 * @email husheng3921@163.com
 */
public class MapTestOne {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        /**查看所有键值对*/
        Set<Map.Entry<String, Integer>> mapEntrys = map.entrySet();
        for (Map.Entry<String, Integer> m : mapEntrys){
            System.out.println(m.getKey()+"->"+ m.getValue());
        }
        /** 查看所有键*/
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /** 查看所有值*/
        Collection<Integer> values = map.values();
        for(Integer value :values){
            System.out.println(value);
        }
    }
}
