package com.hs.algorithm.dp.$322;

import java.util.Arrays;

/**
 * Created by husheng02.
 * 完全背包
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/09 17:46
 */
public class Solution {
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        for (int coin:coins){
            for(int i = coin; i <= amount; i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        if (dp[amount]== amount+1){
            return -1;
        }
        return dp[amount];
    }
    public int coinChange2(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int coin:coins){
                if (i >= coin && dp[i-coin] != amount+1){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1:dp[amount];
    }
}
