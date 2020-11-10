package com.hs.algorithm.maps.$49;

import java.util.*;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/10/07 22:39
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for(String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
