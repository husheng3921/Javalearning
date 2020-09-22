package com.hs.algorithm.unifind.$547;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/14 22:13
 */
public class SolutionII {
    public int findCircleNum(int[][] M){
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++){
            if (visited[i] == 0){
                dfs(M, visited, i);
                count++;
            }
        }
        return 0;
    }
    private void dfs(int[][]M, int[] visited, int i){
        for (int j = 0; j < M.length; j++){
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] =1;
                dfs(M, visited, j);
            }
        }
    }
}
