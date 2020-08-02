package com.hs.algorithm.dp.$72;

/**
 * TODO
 * LC 72 Hard
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=3&sn=aa642cbf670feee73e20428775dff0b5&chksm=9bd7fb33aca0722568ab71ead8d23e3a9422515800f0587ff7c6ef93ad45b91b9e9920d8728e&scene=21#wechat_redirect
 * @author hushe
 * @date 2020/4/23/0023 17:39
 * @email husheng3921@163.com
 */
public class Solution {
    public static void main(String[] args) {
        String word1="horse";
        String word2="ros";
        word1 = "intention";word2 = "execution";
        int res = (new Solution()).minDistance1(word1, word2);
        int mins = (new Solution()).min(1,-2,9);
        //System.out.println(mins);
        System.out.println(res);
    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        return dp(len1-1,len2-1, word1, word2);
    }

    int dp(int i, int j, String word1, String word2) {
        if (i == -1) return j+1;
        if (j == -1) return i+1;
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(i-1, j-1,word1, word2);
        }else{
            return min(dp(i,j-1,word1,word2)+1,
                    dp(i-1,j,word1,word2)+1,
                    dp(i-1,j-1,word1,word2)+1);
        }
    }
    int min(int a, int b, int c) {
        int minRes = Integer.MAX_VALUE;
        if (a < minRes) {
            minRes = a;
        }
        if (b < minRes) {
            minRes = b;
        }
        if (c < minRes){
            minRes = c;
        }
        return minRes;
        //return Math.min(a,Math.max(b,c));
    }

    public int minDistance1(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i < len1+1; i++){
            dp[i][0] = i;
        }
        for (int j = 1; j < len2+1; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }
        return dp[len1][len2];
    }
}
