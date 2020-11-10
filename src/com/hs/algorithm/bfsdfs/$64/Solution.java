package com.hs.algorithm.bfsdfs.$64;

import java.util.Arrays;

/**
 * Created by husheng02.
 * 最小路径和
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/25 9:26
 */
public class Solution {
    int M;
    int N;
    int[][] memor;
    public int minPathSum(int[][] grid){
        M = grid.length;
        N = grid[0].length;
        memor = new int[M][N];
        for (int i = 0; i < M; i++){
            Arrays.fill(memor[i],-1);
        }
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int r, int c) {
        //越界
        if(r < 0 || r >= M || c < 0 || c >= N){
            return Integer.MAX_VALUE;
        }
        if(memor[r][c] > -1){
            return memor[r][c];
        }
        //达到要求
        if(r == M -1 && c == N -1){
            return grid[M-1][N-1];
        }
        int right = dfs(grid,r,c+1);
        int down = dfs(grid,r+1,c);

        int ans = Math.min(right, down)+grid[r][c];

        memor[r][c] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},
                {1,5,1},
                {4,2,1}};
        Solution solution = new Solution();
        int ans = solution.minPathSum(grid);
        System.out.println(ans);
    }
}
