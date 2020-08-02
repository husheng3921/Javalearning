package com.hs.algorithm.dp.$1143;

/**
 * TODO
 * LC 1143
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484486&amp;idx=1&amp;sn=0bdcb94c6390307ea32427757ec0072c&source=41#wechat_redirect
 * @author hushe
 * @date 2020/4/23/0023 11:57
 * @email husheng3921@163.com
 */
public class Solution {

    public static void main(String[] args) {
        String str1 = "abcde", str2 = "ace";
        int res = (new Solution()).longestCommonSubsequence(str1,str2);
        System.out.println(res);
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        //Arrays.fill(dp,0);
        for(int i = 1; i < len1+1; i++) {
            for(int j = 1; j < len2+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
