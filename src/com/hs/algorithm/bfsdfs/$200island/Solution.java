package com.hs.algorithm.bfsdfs.$200island;

/**
 * TODO
 * 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * @author hushe
 * @date 2020/7/18/0018 19:20
 * @email husheng3921@163.com
 */
public class Solution {
    private void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0'){
            return;
        }
        //搜索过的1都置位0
        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;
        for (int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++){
                if (grid[r][c] == '1'){
                    numIslands++;
                    dfs(grid, r, c);
                }
            }
        }
        return numIslands;
    }

    public int numIslands1(char[][] grid){
        return 0;
    }
}
