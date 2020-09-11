package com.hs.algorithm.dp.$714stock;

/**
 * Created by husheng02.
 * 买卖股票的最佳时机含手续费
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 16:43
 */
public class Solution {
    public int maxProfit(int[] prices, int fee){
        int n = prices.length;
        //不持有0，持有1
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            int temp = dp_i_0;
            //不持有，由前一个持有现在售出
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
