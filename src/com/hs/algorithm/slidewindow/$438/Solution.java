package com.hs.algorithm.slidewindow.$438;

import java.util.*;

/**
 * TODO
 * LC438
 * @author hushe
 * @date 2020/4/22/0022 16:04
 * @email husheng3921@163.com
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            int count = need.getOrDefault(p.charAt(i), 0);
            need.put(p.charAt(i),count+1);
        }
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> wind = new HashMap<>();
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            if(need.containsKey(c)){
                int count = wind.getOrDefault(c,0);
                wind.put(c,count + 1);
                if(need.get(c).intValue() == wind.get(c).intValue()) {
                    valid++;
                }
            }
            //判断左边
            while (right - left >= p.length()){
                //符合条件加入索引
                if(valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                //进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if (need.get(d).intValue()==wind.get(d).intValue()) {
                        valid --;
                    }
                    int count = wind.get(d);
                    wind.put(d, count-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s="cbaebabacd", p="abc";
        List<Integer> res = (new Solution()).findAnagrams(s,p);
        Iterator<Integer> it = res.iterator();
        while (it.hasNext()){
        System.out.println(it.next());
        }
    }
}
