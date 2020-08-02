package com.hs.algorithm.dp.$62;

import java.util.Arrays;

/**
 * TODO
 * LC 62 不同路径
 * @author hushe
 * @date 2020/4/25/0025 17:45
 * @email husheng3921@163.com
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i<m;i++){
            for (int j = 1; j < n;j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.uniquePaths(3,2));
        System.out.println(so.uniquePaths(7,3));
    }
}
