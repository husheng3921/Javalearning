package com.hs.algorithm.traceback.$79;

/**
 * Created by husheng02.
 * 单词搜索
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/08 20:11
 */
public class Solution {
    boolean checked[][];
    public boolean exist(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;
        checked = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(back(board, word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean back(char[][] board, String word, int i, int j, int wordIndex){
        //递归终止条件
        if(wordIndex == word.length()){
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] != word.charAt(wordIndex) || checked[i][j]){
            return false;
        }else{
            checked[i][j] = true;
        }
        boolean res = back(board,word,i,j-1, wordIndex+1) || back(board, word, i, j+1, wordIndex+1) ||
                back(board, word, i+1, j, wordIndex+1)||back(board, word, i-1, j, wordIndex+1);
        checked[i][j] = false;//回溯
        return res;
    }
}
