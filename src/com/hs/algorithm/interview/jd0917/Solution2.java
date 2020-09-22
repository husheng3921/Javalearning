package com.hs.algorithm.interview.jd0917;

/**
 * Created by husheng02.
 *  公主与王子之间路径可达
 *  S表示王子，E表示公主
 *  #不可过，.可过
 *  2 2
 *  #E
 *  S#
 *  NO
 *  dfs
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 21:09
 */
public class Solution2 {
    boolean vis[][];
    public boolean solution(char[][] chars){
        int n = chars.length;
        int m = chars[0].length;
        vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                //从王子的地方开始搜索
                if (chars[i][j] == 'S'){
                   return dfs(chars, i, j);
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] chars, int i, int j) {
        //边界情况
        int n = chars.length;
        int m = chars[0].length;
        //越界，或者已访问，或不可达
        if(i < 0 || j < 0|| i >= n || j >= m || vis[i][j] || chars[i][j]=='#'){
            return false;
        }
        vis[i][j] = true;
        //是否达到目的地，公主
        if (chars[i][j] == 'E'){
            return true;
        }
        //继续搜索
        return dfs(chars,i+1,j)||dfs(chars,i-1,j)||dfs(chars,i,j-1)||dfs(chars,i,j+1);
    }
}
