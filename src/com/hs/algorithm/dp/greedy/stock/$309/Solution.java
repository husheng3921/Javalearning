package com.hs.algorithm.dp.greedy.stock.$309;

/**
 * TODO
 * LC309 股票买卖时机含冷冻期 中等
 * @author hushe
 * @date 2020/5/2/0002 21:44
 * @email husheng3921@163.com
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0){
                dp[i][1] = -prices[i];
                dp[i][0] = 0;
                continue;
            }else if (i==1){
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], 0 - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        return dp[n-1][0];
    }
    public int maxProfit0(int[] prices){
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;//dp[i-2][0]
        for (int i = 0; i < n; i++){
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        Solution solution = new Solution();
        int res = solution.maxProfit(prices);
        System.out.println(res);
        int res0 = solution.maxProfit0(prices);
        System.out.println(res0);
    }
}
