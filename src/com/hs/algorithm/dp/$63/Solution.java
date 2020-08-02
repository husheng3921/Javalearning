package com.hs.algorithm.dp.$63;

/**
 * TODO
 * LC63 不同路径II，有障碍物
 * @author hushe
 * @date 2020/4/25/0025 18:05
 * @email husheng3921@163.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution ss = new Solution();
        int[][] nums ={{0,1,0},{0,1,0},{0,0,0}};
        System.out.println(ss.uniquePathsWithObstacles(nums));
    }

    /**
     * 通不过
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] ==0) {
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for (int j= 1; j< n; j++){
            if (obstacleGrid[0][j] == 0 && obstacleGrid[0][j-1] == 0) {
                dp[0][j] = 1;
            }else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                /*if (obstacleGrid[i-1][j] == 0 && obstacleGrid[i][j-1] == 0 ){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }else if(obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1 ){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }*/
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        boolean iflag = false;
        boolean jflag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    if (i == 0) iflag = true;
                    if (j == 0) jflag = true;
                } else if (i == 0) {
                    dp[i][j] = iflag ? 0 : 1;
                } else if (j == 0) {
                    dp[i][j] = jflag ? 0 : 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
