package com.hs.algorithm.unifind.$694;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by husheng02.
 * 不同岛屿数量
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 20:56
 */
public class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    StringBuilder island = new StringBuilder();
                    dfs(grid,island,i,j,i,j);
                    islands.add(island.toString());
                }
            }
        }
        return islands.size();
    }
    private void dfs(int[][] grid, StringBuilder island, int i, int j, int originI, int originJ){
        if(i < 0|| i>= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;//搜过的地方置为0
        island.append(i - originI);
        island.append(j - originJ);
        dfs(grid,island,i+1, j, originI, originJ);
        dfs(grid,island,i-1,j,originI,originJ);
        dfs(grid, island, i, j+1, originI, originJ);
        dfs(grid, island, i, j-1, originI, originJ);
    }
}
