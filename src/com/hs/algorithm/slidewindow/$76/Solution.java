package com.hs.algorithm.slidewindow.$76;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * LC 76
 * @author hushe
 * @date 2020/4/22/0022 9:22
 * @email husheng3921@163.com
 */
public class Solution {

    /**
     *  暴力循环,待解决
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        boolean flag = false;
        String res =s;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++) {
                String str = s.substring(i,j);
                for(int k = 0; k < t.length(); k++){
                    if(str.contains(t.charAt(k)+"")){
                       flag = true;
                    }else {
                        flag = false;

                    }
                }
                if(flag){
                    res = res.length() > str.length() ? str : res;
                }

            }
        }
        return res == s ? "" : res;
    }

    public String minWindow(String s, String t) {

        int left = 0, right = 0;
        int valid = 0;
        Map<Character, Integer> dictT = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i),0);
            dictT.put(t.charAt(i),count+1);
        }
        Map<Character, Integer> windCounts = new HashMap<>();
        //记录最小覆盖子串的起始索引及长度
        int start = 0, len = s.length()+1;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if(dictT.containsKey(c) ) {
                int count = windCounts.getOrDefault(c,0);
                windCounts.put(c, count+1);
                if(windCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    valid++;
                }

            }
            while (valid == dictT.size()){
                if(right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if(dictT.containsKey(d) ){

                    if(windCounts.get(d).intValue() == dictT.get(d).intValue()) {
                        valid--;
                    }

                    int count = windCounts.get(d);
                    windCounts.put(d,count-1);
                }

            }

        }
        return len == s.length()+1 ?"":s.substring(start,start+len);
    }
    public int[] list(int[] stock) {
        int[] res = new int[stock.length];
        for(int i = 0; i < stock.length; i++) {
            for(int j = i + 1; j < stock.length; j++) {
                if(stock[j] > stock[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
    public int[] list1(int[] stock){
        int[] res = new int[stock.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < stock.length-1; i++){
            map.put(i, stock[i]);
        }
        for(int j = 0; j<stock.length;j++){
            if (stock[j]<stock[j+1]){
                res[j]++;
            }
        }
        return res;
    }
    public int[] list2(int[] rooms, int N ){
        int len = rooms.length;
        int res[] = new int[len];
       System.arraycopy(rooms,0,res,0,len);
        for(int i = 0; i < N; i++){
            int[] temp =new int[len];
            System.arraycopy(res,0,temp,0,len);
            res[0] = 0;
            res[len - 1] = 0;
            for(int j = 1; j < len - 1;j++){
                res[j] = (temp[j-1] ^ temp[j+1])==1 ? 0:1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
       String S = "ADOBECODEBANC";
       String T = "ABC";
       S = "a";
       T ="a";
        String res = (new Solution()).minWindow(S, T);
        System.out.println(res);
        /*int[] stock = {23, 24, 25, 21, 12, 22, 31, 23};
        int[] reslist = (new Solution()).list(stock);
        for(int item:reslist){
            System.out.print(item+" ");
        }*/
        /*int a = 1, c = 1;
        int a1 = 1, c1 =0;
        int a2 = 0, c2 = 0;
        System.out.println(1^(a^c));
        System.out.println(1^(a1^c1));
        System.out.println(1^(a2^c2));

        int[]rooms = {0,1,0,1,1,0,0,1};
        int[]res = (new Solution().list2(rooms, 7));
        for(int item : res){
            System.out.print(item+" ");
        }*/
        //System.out.println(res);
    }
}
