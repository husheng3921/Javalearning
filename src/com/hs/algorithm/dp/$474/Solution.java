package com.hs.algorithm.dp.$474;

/**
 * Created by husheng02.
 * 一和零 中等
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/08 16:53
 */
public class Solution {
    private int[] countZeroAndOne(String str){
        int[] cnt = new int[2];
        for (char c:str.toCharArray()){
            cnt[c - '0']++;
        }
        return cnt;
    }
    public int findMaxForm(String[] strs, int m, int n){
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i = 1; i <= len; i++){
            int[] cnt = countZeroAndOne(strs[i-1]);
            for (int j = 0; j <= m; j++){
                for (int k = 0; k <= n; k++){
                    dp[i][j][k] = dp[i-1][j][k];

                    int zeros = cnt[0];
                    int ones = cnt[1];
                    //0-1背包，选当前字符不选当前字符
                    if (j >= zeros && k >= ones){
                        dp[i][j][k]=Math.max(dp[i-1][j][k], dp[i-1][j - zeros][k-ones]+1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}
