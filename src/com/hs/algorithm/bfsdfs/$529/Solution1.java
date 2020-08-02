package com.hs.algorithm.bfsdfs.$529;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/5/0005 19:26
 * @email husheng3921@163.com
 */
public class Solution1 {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 相邻位置 board[row-i][col-j]
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public char[][] updateBoard(char[][] board, int[] click){
        dfs(board,click[0],click[1]);
        return board;
    }

    void dfs(char[][] board, int x, int y){
        int r = board.length;
        int c = board[0].length;
        if (x <0 || x >= r || y < 0 || y >= c) {
            return;
        }
        if (board[x][y] == 'E'){
            board[x][y] = 'B';
            int count = judge(board, x, y);
            if (count == 0){
                for (int i = 0; i < 8; i++){
                    dfs(board,x + dx[i],y + dy[i]);
                }
            }else{
                board[x][y]=(char)(count + '0');
            }
        }else if (board[x][y] == 'M'){
            board[x][y] = 'X';
        }
    }

    int judge(char[][] board, int x, int y){
        int r = board.length;
        int c = board[0].length;
        int count = 0;
        for (int i = 0; i < 8; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= r || newY <0 || newY <0 || newY >= c){
                continue;
            }
            if (board[newX][newY] == 'M'){
                count++;
            }
        }
        return count;
    }
    public char[][] updateBoard1(char[][] board, int[] click){
        int r = board.length;
        int c = board[9].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (board[x][y] == 'E'){//如果为E，才进行判断是否要递归相邻结点
                board[x][y] = 'B';
                int count = judge(board, x, y);
                if (count == 0){
                    for (int i = 0; i < 8; i++){
                        int newX = x + dx[i];
                        int newY = y + dy[i];
                        if (newX < 0 || newX >= r || newY <0 || newY <0 || newY >= c){
                            continue;
                        }
                        queue.add(new int[]{newX, newY});
                    }
                }else{
                    board[x][y]=(char)(count + '0');
                }
            }else if (board[x][y] == 'M'){//如果当前结点为M，则只更新当前结点
                board[x][y] = 'X';
            }
        }
        return board;
    }

}
