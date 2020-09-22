package com.hs.algorithm.jzoffer.$48;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by husheng02.
 * 最长不含重复字符的子字符串
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/12 14:16
 */
public class Solution {
    public int lengthOfLongestSubString(String s){
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0;
        while (right < s.length()){
            while (set.contains(s.charAt(right))){
                //包含重复的，移除左边的
                set.remove(s.charAt(left));
                left++;
            }
            //右指针移动，得到新的元素
            set.add(s.charAt(right));
            right++;
            max = Math.max(right - left, max);
        }
        return max;
    }
}
