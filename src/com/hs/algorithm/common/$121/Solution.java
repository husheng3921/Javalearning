package com.hs.algorithm.common.$121;

/**
 * Created by husheng02.
 * 股票买卖1
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 21:50
 */
public class Solution {
    /**
     * 当前之前的最小股票价是多少，今天卖出的利润，和之前的比较
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] -minPrice;
            }
        }
        return maxProfit;
    }
    public int maxProfit1(int[] prices){
        if(prices == null || prices.length == 0){
            return 0;
        }
        int i= 0, j = 1;//双指针，买点和售电
        int max = 0;
        while (i < prices.length && j < prices.length){
            int res = 0;
            if (prices[j] > prices[i]){
                res = prices[j] - prices[i];
                max = Math.max(res, max);
            }else{
                i = j;//当前点小于买点，移动买点指针
            }
            j++;//售点后移

        }
        return max;
    }
}
