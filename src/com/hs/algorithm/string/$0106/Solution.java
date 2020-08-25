package com.hs.algorithm.string.$0106;

/**
 * Created by husheng02.
 * 字符串压缩
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/25 10:13
 */
public class Solution {
    public String compressString(String s){
        int n = s.length();
        StringBuilder res = new StringBuilder("");
        int i = 0;
        while (i < n){
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)){
                j++;
            }
            res.append(s.charAt(i));
            res.append(j-i);
            i= j;
        }
        String ans = res.toString();
        if (res.length() < s.length()){
            return ans;
        }else{
            return s;
        }
    }
}
