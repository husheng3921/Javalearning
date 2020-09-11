package com.hs.algorithm.dp.$309stock;

/**
 * Created by husheng02.
 * 最佳股票时机冷冻期
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 16:28
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;//
        for (int i = 0; i < n; i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
