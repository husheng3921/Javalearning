package com.hs.algorithm.dp.greedy.stock.$121;

/**
 * TODO
 * LC121 买卖股票的最佳时机 简单 只能完成一次交易获益最大
 * @author hushe
 * @date 2020/5/2/0002 18:57
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 暴力法 O(n) O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        //循环买点和售点
        for (int i = 0; i < prices.length -1; i++){
            for (int j = i +1; j < prices.length; j++){
                if (prices[j] > prices[i]){
                    res = Math.max(res, prices[j] - prices[i]);
                }
            }
        }
        return res;
    }

    /**
     * 双指针-起点和售点 O(n) O(1)
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices){
        if (prices == null || prices.length <2){
            return 0;
        }
        int n = prices.length;
        int res = 0;
        int sum = 0;
        int i = 0, j = 1;//双指针，买点和售点
        while (i < n && j < n){
            if (prices[j] > prices[i]){
                sum = prices[j] - prices[i];
            }else {//买点值大于售点值，则不买入，更新售点为买点
                i = j;//交换起点
            }
            j++;//售点指针后移
            res = Math.max(res, sum);//更新收益最大值

        }
        return res;
    }

    public int maxProfit2(int[] prices){
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }else if(prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 动态规划 k=1
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices){
        int n = prices.length;
        int[][]dp = new int[n][2];//持有和不持有
        for (int i= 0; i < n;i++){
            if (i-1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);//0表示不持有，1表示持有股票
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n-1][0];

    }
    public int maxProfit33(int[] prices){
        int n = prices.length;
        //base case: dp[-1][0] = 0, dp[-1][1]=-infinity;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            //dp[i][0] =
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        Solution solution = new Solution();
        int res = solution.maxProfit(prices);
        System.out.println(res);
        int res3 = solution.maxProfit33(prices);
        System.out.println(res3);
    }
}
