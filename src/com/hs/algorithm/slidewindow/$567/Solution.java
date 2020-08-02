package com.hs.algorithm.slidewindow.$567;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *LC 567
 * @author hushe
 * @date 2020/4/22/0022 15:43
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            int count = need.getOrDefault(s1.charAt(i),0);
            need.put(s1.charAt(i), count+1);
        }
        int left = 0, right = 0;
        int valid = 0;
        Map<Character, Integer> windCount = new HashMap<>();
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            //进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                int count = windCount.getOrDefault(c,0);
                windCount.put(c, count+1);
                if(windCount.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }
            //判断缩进
            while (right - left >= s1.length()){
                //在这里判断是否找到合适的子串
                if(valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left ++;
                if(need.containsKey(d)){
                    if(windCount.get(d).intValue() == need.get(d).intValue()){
                        valid--;
                    }
                   int count= windCount.get(d)-1;
                    windCount.put(d, count);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 ="ab", s2="eidbaooo";
        s1="hello";
        s2="ooolleoooleh";
        s1="abc";
       s2= "ccccbbbbaaaa";
        boolean res = (new Solution()).checkInclusion(s1, s2);
        System.out.println(res);
    }
}
