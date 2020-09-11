package com.hs.algorithm.dp.$121stock;

/**
 * Created by husheng02.
 * 股票买卖的最佳时机,完成一笔交易
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 15:41
 */
public class Solution {
    /**
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
    public int maxProfit1(int[] prices){
        int i = 0, j = 1;//双指针
        int max = 0;
        while (i < prices.length && j < prices.length){
            if(prices[i] < prices[j]){
                max = Math.max(max, prices[j] - prices[i]);
            }else {
                //当前值小于i处值，交换售买
                i = j;

            }
            j++;
        }
        return max;
    }

}
