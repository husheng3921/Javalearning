package com.hs.algorithm.dp.$983;

/**
 * Created by husheng02.
 * medium 最低票
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/31 21:15
 */
public class Solution {
    public int mincostTicks(int[] days, int[] costs){
        //当天花的最低票
        int[] dp = new int[days[days.length - 1] + 1];
        //base case.第0天不用买票
        dp[0] = 0;
        //标记下需要买票的日子
        for(int day: days){
            dp[day] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < dp.length; i++){
            if(dp[i] == 0){
                //不出门不需要买票
                dp[i] = dp[i - 1];
                continue;
            }
            //当天需要买票
            //一日票
            int one = dp[i-1] + costs[0];
            //如果今天距离第一天超过7天，则直接第一天买七日票
            int seven = i > 7 ? dp[i-7] + costs[1]:costs[1];
            //30天同理
            int thirty = i > 30 ? dp[i-30] + costs[2]:costs[2];
            dp[i] = Math.min(one, Math.min(seven, thirty));
        }
        return dp[days[days.length - 1]];
    }
}
