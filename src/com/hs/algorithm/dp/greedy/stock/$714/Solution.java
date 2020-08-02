package com.hs.algorithm.dp.greedy.stock.$714;

/**
 * TODO
 * LC714 买卖股票的最佳时机含手续费 中等
 * @author hushe
 * @date 2020/5/2/0002 21:31
 * @email husheng3921@163.com
 */
public class Solution {
    public static void main(String[] args) {
       int[] prices = {1, 3, 2, 8, 4, 9};
       int fee = 2;
       Solution solution = new Solution();
       int res = solution.maxProfit(prices, fee);
        System.out.println(res);
        int res0 = solution.maxProfit0(prices, fee);
        System.out.println(res0);
    }

    /**
     * 动态规划
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];//k无限
        for (int i = 0; i < n; i++){
            if (i == 0){
                dp[i][0] = 0;
                dp[i][1] = - prices[i]-fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] -fee);
        }
        return dp[n-1][0];
    }
    public int maxProfit0(int[] prices, int fee){
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - fee -prices[i]);
        }
        return dp_i_0;
    }

}
