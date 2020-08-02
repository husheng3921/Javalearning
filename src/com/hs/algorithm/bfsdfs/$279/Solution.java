package com.hs.algorithm.bfsdfs.$279;

import java.util.Arrays;

/**
 * TODO
 * LC 279 dp  完全平方数
 * @author hushe
 * @date 2020/4/23/0023 17:10
 * @email husheng3921@163.com
 */
public class Solution {

    public static void main(String[] args) {
        int res = (new Solution()).numSquares(12);
        System.out.println(res);
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        int maxSquareIndex = (int) Math.sqrt(n) + 1;//可分解完全平方数的最大根 例如12->3*3 =9
        int[] squareNums = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++){
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxSquareIndex; j++) {
                if (i < squareNums[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i-squareNums[j]]+1);
            }
        }
        return dp[n];
    }
}
