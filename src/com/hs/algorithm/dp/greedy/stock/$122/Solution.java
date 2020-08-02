package com.hs.algorithm.dp.greedy.stock.$122;

/**
 * TODO
 * LC122 股票销售的最佳时机II  简单 不限交易次数 k= +infinity
 * @author hushe
 * @date 2020/5/2/0002 18:45
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 挨个比较计算 O(n) O(1),相邻比较，每天都买卖
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i] < prices[i + 1]){
                res = res + prices[i+1] - prices[i];
            }
        }
        return res;
    }

    /**
     * 动态规划 k不受限制
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            int temp = dp_i_0;
            //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            //dp[i][1] = max(dp[i-1][1],dp[i-1][0] - prices[i])
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }
    public int maxProfit20(int[] prices){
        int n = prices.length;
        int[][]dp = new int[n][2];//持有和不持有
        for (int i= 0; i < n;i++){
            if (i-1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);//0表示不持有，1表示持有股票
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];

    }
    public static void main(String[] args) {
        int[] prices ={7,1,5,3,6,4};
        Solution solution = new Solution();
        int res = solution.maxProfit(prices);
        System.out.println(res);
        int res2 = solution.maxProfit20(prices);
        System.out.println(res2);
    }
}
