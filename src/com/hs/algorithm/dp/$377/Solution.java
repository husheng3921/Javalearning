package com.hs.algorithm.dp.$377;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/09 17:37
 */
public class Solution {
    public int combinationSum4(int[] nums, int target){
        int[] dp = new int[target+1];
        //
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for (int num:nums){
                if(num<= i){
                    dp[i] = dp[i]+dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
