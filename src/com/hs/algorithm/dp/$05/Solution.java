package com.hs.algorithm.dp.$05;

/**
 * TODO
 * LC05 最长回文子串问题
 * @author hushe
 * @date 2020/4/23/0023 11:16
 * @email husheng3921@163.com
 */
public class Solution {

    public String longestPalindrome(String s) {
        boolean[][] p = new boolean[s.length()][s.length()];
        String res = "";

        return res;
    }

    /**
     *  双指针法
     *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484471&idx=1&sn=7c26d04a1f035770920d31377a1ebd42&chksm=9bd7fa3faca07329189e9e8b51e1a665166946b66b8e8978299ba96d5f2c0d3eafa7db08b681&scene=21#wechat_redirect
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        String res="";
        for(int i = 0; i < s.length(); i++) {
            //以s[i]为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            //以s[i],s[i+1]为中心的回文子串
            String s2 = palindrome(s, i, i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
    public String palindrome(String s, int l, int r) {
        //防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            //向两边展开
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
    public static void main(String[] args) {
        String s = "babad";
        s ="cbbd";
        String res = (new Solution()).longestPalindrome(s);
        System.out.println(res);
    }
    public String solution(String s){
        //特判
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++){
            for (int i = 0; i < j; i++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){//两个字符，三个字符，首尾相同
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];//转移
                    }
                }
                if(dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
