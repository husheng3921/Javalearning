package com.hs.algorithm.dp.$518;

/**
 * TODO
 * LC518 零钱兑换II 中等
 * @author hushe
 * @date 2020/4/24/0024 15:05
 * @email husheng3921@163.com
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //dp[i][j]使用前i个硬币组成j的方案数

        int[][] dp = new int[n + 1][amount + 1];
        // base case,金额为0时，任何都不选，为1
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        /**
         * dp[i][j]：coins[0-i-1]这i个硬币，组成金额为j,得到的组合数
         * dp[i][j]依赖两个状态：1、不选coins[i-1],只能在前i-1个凑成j
         * 2、选conis[i]，则总金额减少到j-coins[i-1],dp[i][j-coins[i-1]
         * */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++)
                if (j - coins[i-1] >= 0)
                    dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
        }
        return dp[n][amount];
    }
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }
/*
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/



    public static void main(String[] args) {

    }
}
