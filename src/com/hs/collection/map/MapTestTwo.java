package com.hs.collection.map;

import java.util.TreeMap;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/4/0004 13:02
 * @email husheng3921@163.com
 */
public class MapTestTwo {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
    }
    class Key implements Comparable<Key>{

        @Override
        public int compareTo(Key o) {
            return -1;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
