package com.hs.algorithm.dp.greedy.$322;

import java.util.Arrays;

/**
 * TODO
 * LC322 零钱兑换 中等
 * @author hushe
 * @date 2020/5/2/0002 12:41
 * @email husheng3921@163.com
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int rem, int[] count){
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem-1];
        int min = Integer.MAX_VALUE;
        for (int coin :coins){
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res <min){
                min = res + 1;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1:min;
        return count[rem-1];
    }

    /**
     * 动态规划，自下而上，F(i)为组成金额i所需最少的硬币数量，
     * F(i) = min F(i-cj) + 1 (j[0..n-1])
     * cj代表第j枚硬币的面值，即我们枚举最后一枚硬币面额是cj,那么从i-cj状态F(i-cj)
     * 转移过来，加上这枚硬币数量1的贡献，由于硬币数量最少，则F(i)为前面能转移过来的状态的最小值加1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i= 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    int res = Integer.MAX_VALUE;
    public int coinChange2(int[] coins, int amount){
        if (coins.length == 0){
            return -1;
        }

        if (res == Integer.MAX_VALUE){
            return -1;//没有一种硬币组合
        }
        return res;
    }
    //递归
    public void findWay(int[] coins, int amount, int count){
        if (amount < 0) return;
        if (amount == 0) res = Math.min(res, count);
        for (int i = 0; i < coins.length; i++){
            findWay(coins, amount - coins[i], count + 1);
        }
    }

    //记忆化搜索
    int[] memo;
    public int coinChange3(int[] coins, int amount){
        if (coins.length == 0) return -1;
        memo = new int[amount];
        return findWay3(coins,amount);
    }
    //memo[n]表示硬币n可以被换取的最少的硬币树，不能换取为-1
    public int findWay3(int[] coins, int amount){
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (memo[amount-1]!=0){
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++){
            int res = findWay3(coins, amount - coins[i]);
            if (res >= 0 && res < min){
                min = res + 1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }
}
