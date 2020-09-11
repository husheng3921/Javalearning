package com.hs.algorithm.bfsdfs.offer13;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/11 13:58
 */
public class Solution {
    boolean checked[][];
    public int movingCount(int m, int n, int k){
        checked = new boolean[m][n];
        return dfs(m, n, k,0, 0 );
    }

    private int dfs(int m, int n, int k, int i, int j){
        if(i < 0 || i >= m || j <0 || j >= n || checked[i][j] || sum(i,j) > k){
            return 0;
        }
        checked[i][j] = true;
        //从一个方向进，只需要走其他三个方向，下，右


        return 1 + dfs(m, n, k,i + 1, j) + dfs(m, n, k,i, j + 1) + dfs(m, n, k,i - 1, j) + dfs(m, n, k,i, j - 1);
    }
    private int sum(int i, int j){
        int sum = 0;
        while (i != 0){
            sum += i % 10;
            i = i / 10;
        }
        while (j != 0){
            sum += j % 10;
            j = j / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.movingCount(2, 3, 1);
        System.out.println(res);
    }
}
