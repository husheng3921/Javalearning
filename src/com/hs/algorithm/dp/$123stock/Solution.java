package com.hs.algorithm.dp.$123stock;

/**
 * Created by husheng02.
 * 买卖股票最佳时机III最多完成2笔交易
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 17:00
 */
public class Solution {
    /**
     * dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
     *          max(选择 rest,   选择sell)
     * 今天没有持有股票，两种可能：
     * 1、昨天没有，今天rest
     * 2、昨天持有，今天sell，所以今天没有持有股票
     * dp[i][k][1]=max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     *          max(选择rest， 选择buy)
     * 持有股票：
     * 1、昨天有，今天选择rest，
     * 2、昨天没有，今天选择buy
     */
    public int maxProift(int[] prices){
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k+1][2];
        for (int i = 0;i < n; i++){
            for (int k = max_k; k >= 1; k--){
                if(i - 1 == -1){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][max_k][0];
    }
    public int maxProfit(int[] prices){
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices){
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
     */
}
