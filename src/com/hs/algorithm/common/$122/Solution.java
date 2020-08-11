package com.hs.algorithm.common.$122;

/**
 * Created by husheng02.
 * 股票买卖II
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 22:04
 */
public class Solution {
    public int maxProfit(int[] prices){
        int res = 0;
        int len = prices.length;
        for (int i =0; i < len - 1; i++){
            int diff = prices[i+1] -prices[i];
            if(diff > 0){
                res += diff;
            }
        }
        return res;
    }
}
