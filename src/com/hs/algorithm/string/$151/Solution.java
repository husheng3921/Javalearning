package com.hs.algorithm.string.$151;

/**
 * Created by husheng02.
 * 单词翻转
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/12 11:05
 */
public class Solution {
    public String reverseWords(String s){
        s = s.trim();//首尾去掉空格
        int j = s.length()-1, i = j;//从尾向首遍历
        StringBuilder res = new StringBuilder();
        while (i >= 0){
            while (i>=0 && s.charAt(i)!=' '){
                i--;//搜索首个空格
            }
            res.append(s.substring(i+1,j+1)+" ");
            while (i >= 0 &&s.charAt(i)==' '){
                i--;//跳过空格
            }
            j= i;//j指向下个单词尾字符
        }
        return res.toString().trim();
    }
}
