package com.hs.algorithm.slidewindow.$3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO
 * LC03 最长无重复子串
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&mpshare=1&scene=1&srcid=&sharer_sharetime=1587520062172&sharer_shareid=e1e9f1e1e1641a07de78dda588fb8ebe#rd
 * @author hushe
 * @date 2020/4/22/0022 16:40
 * @email husheng3921@163.com
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> wind = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;//记录结果
        while (right < s.length()){
            char c = s.charAt(right);
            right ++;
            //进行窗口更新
            int count = wind.getOrDefault(c,0);
            wind.put(c, count+1);
            //判断左窗口收缩
            while (wind.get(c)>1){
               char d = s.charAt(left);
                left++;
                count = wind.get(d);
                wind.put(d, count-1);
            }
            res = Math.max(res, right -left);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int right = 0, left = 0; right < n; right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return ans;

    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(k)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, right = 0, left =0;
        while (right < n && left < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right ++;
                ans = Math.max(ans, right - left);
            }else{
                set.remove(s.charAt(left));
                left ++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        s ="pwwkew";
        int res = (new Solution()).lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
