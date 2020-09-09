package com.hs.algorithm.dp.$279;

import java.util.Arrays;

/**
 * Created by husheng02.
 *  完全平方数 中等
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/08 15:28
 */
public class Solution {
    public int numSquares(int n) {
        //定义dp[]为n的完全平方数最少个数
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //边界
        dp[0] = 0;

        int maxSquareIndex = (int)Math.sqrt(n) + 1;
        int[] squareNums = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++){
            squareNums[i] = i*i;
        }

        for (int i = 1; i <= n; i++){
            for (int s = 1; s < maxSquareIndex; s++){
                if (i < squareNums[s]){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squareNums[s]] + 1);
            }
        }
        return dp[n];
    }
}
