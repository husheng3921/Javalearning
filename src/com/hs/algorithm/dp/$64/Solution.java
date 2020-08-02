package com.hs.algorithm.dp.$64;

/**
 * TODO
 * 64 medium
 * @author hushe
 * @date 2020/7/18/0018 11:41
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 自顶向下 二维
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }

    /**
     * 无额外空间
     * @param grid
     */
    public int minPathSum1(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < n; i++){
            grid[i][0] += grid[i-1][0];
        }
        for (int j = 1; j < m; j++){
            grid[0][j] += grid[0][j];
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1])+grid[i][j];
            }
        }
        return grid[n-1][m-1];
    }

    public int minPathSum2(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        //从左至右
        int[] dp = new int[m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j <m; j++){
                if (i == 0 && j==0){
                    dp[0] = grid[0][0];
                }else if (i == 0){
                    //从左至右
                    dp[j] = dp[j-1] + grid[i][j];
                }else if (j == 0){
                    //从上至下
                    dp[j] = dp[j] + grid[i][j];
                }else {
                    dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
                }
            }

        }
        return dp[m-1];
    }

    /**
     * 自底向上
     * @param grid
     * @return
     */
    public int minPathSum3(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = grid[n-1][m-1];
        for(int i = n -1; i >=0; i--){
            for (int j = m - 1; j >= 0; j--){
                if (i == n -1 && j!= m-1){
                    dp[i][j] = dp[i][j+1] + grid[i][j];
                }else if(j == m-1 && i != n-1){
                    dp[i][j] = dp[i+1][j] + grid[i][j];
                }else if (i != n-1 && j != m-1){
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
}
