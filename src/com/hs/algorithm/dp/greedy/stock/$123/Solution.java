package com.hs.algorithm.dp.greedy.stock.$123;

/**
 * TODO
 * LC123 困难 买卖股票最佳时机III 最多可以完成两笔交易,不能同时参与两笔交易 k<=2
 * @author hushe
 * @date 2020/5/2/0002 19:32
 * @email husheng3921@163.com
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        /**
         * dp[i][j] 表示[0,i]区间里，状态为j的最大收益
         * j = 0;什么都不做
         * j = 1;第一次买入
         * j = 2;第一次卖出
         * j = 3:第二次买入
         * j = 4 第二次卖出
         */
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //3 状态都没有发生
        for (int i = 0; i < len; i++){
            dp[i][3] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < len; i++) {
            // j = 0 的值永远是 0
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

       //最大值只发生在不持股的时候，因此来源有3个： j = 0, j = 2, j = 4
        return Math.max(0, Math.max(dp[len - 1][2], dp[len - 1][4]));
    }

    public int maxProfit2(int[] prices){
        int max_k = 2;
        int n = prices.length;
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

    public static void main(String[] args) {
        int[] prices ={3,3,5,0,0,3,1,4};
        Solution solution = new Solution();
        int res = solution.maxProfit(prices);
        System.out.println(res);
        int res2 = solution.maxProfit2(prices);
        System.out.println(res2);
    }
}
