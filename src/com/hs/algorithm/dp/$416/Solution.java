package com.hs.algorithm.dp.$416;

/**
 * Created by husheng02.
 * 和子集分割
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/08 16:01
 */
public class Solution {
    public boolean canPartition(int[] nums){
        int len = nums.length;
        if(len == 0){
            return false;
        }
        int sum = 0;
        for (int num:nums){
            sum += num;
        }
        if((sum & 1) == 1){
            //和为奇数直接返回
            return false;
        }
        int target = sum/2;
        //创建二维状态数组，行：物品索引，列：容量
        boolean[][] dp = new boolean[len][target+1];
        if (nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1; i < len; i++){
            for(int j =0; j <= target; j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
    public boolean canPartition1(int[] nums){
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if(nums[0] <= target){
            dp[nums[0]] =true;
        }
        for(int i = 1; i < len; i++){
            for(int j = 0; j <= target;j++){
                if(dp[target]){
                    return true;
                }
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
