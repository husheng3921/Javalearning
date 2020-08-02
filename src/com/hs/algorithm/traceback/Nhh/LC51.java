package com.hs.algorithm.traceback.Nhh;

import java.util.*;

/**
 * TODO
 * N皇后 51 困难
 * @author hushe
 * @date 2020/5/7/0007 10:34
 * @email husheng3921@163.com
 */
public class LC51 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //'.'表示空，‘Q’表示皇后，初始化棋盘
        String[] board = new String[n];
        char [] rowStr = new char[n];
        Arrays.fill(rowStr,'.');
        String str = new String(rowStr);
        Arrays.fill(board,str);


        return res;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 选择列表： 第row行所有列，都是放置皇后的选择
     * 结束条件：row超过board的最后一行
     * @param board
     * @param row
     */
    void backtrack(String[] board, int row){
        //触发结束条件
        if (row == board.length){
            res.add(Arrays.asList(board));
        }
    }

    public static void main(String[] args) {
        LC51 so = new LC51();
        int n = 8;
        String[] board = new String[n];
        char [] rowStr = new char[n];
        Arrays.fill(rowStr,'.');
        String str = new String(rowStr);
        Arrays.fill(board,str);

        for (String b : board){
            System.out.println(b);
        }
    }
}
