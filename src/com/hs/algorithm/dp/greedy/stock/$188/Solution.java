package com.hs.algorithm.dp.greedy.stock.$188;

/**
 * TODO
 * LC188 难 买卖股票的最佳时机 IV 最多可以完成K笔交易
 * @author hushe
 * @date 2020/5/2/0002 19:54
 * @email husheng3921@163.com
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        Solution solution = new Solution();
        int res = solution.maxProfit(k, prices);
        System.out.println(res);
    }

    public int maxProfit(int K, int[] prices) {
        int max_k = K;
        int n = prices.length;
        if (n <= 1) return 0;

        /*if (max_k > n/2){
            return maxProfit()
        }*/
        int[][][]dp = new int[n][max_k+1][2];//持有和不持有
        for (int i= 0; i < n;i++){
            for (int k = max_k; k >=1; k--){
                if (i - 1 ==-1){
                    /**处理base*/
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0]- prices[i]);//
            }
        }
        //穷举了n * max_k * 2个状态
        return dp[n-1][max_k][0];
    }
}
