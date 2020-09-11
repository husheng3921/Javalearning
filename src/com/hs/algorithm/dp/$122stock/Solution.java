package com.hs.algorithm.dp.$122stock;

/**
 * Created by husheng02.
 * 股票买卖最佳时机II，多次买卖
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 16:23
 */
public class Solution {
    public int maxProfit(int[] prices){
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices){
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);

        }
        return dp_i_0;
    }
}
