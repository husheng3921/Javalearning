package com.hs.algorithm.dp.$152;

/**
 * Created by husheng02.
 * 乘积最大子数组
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 15:02
 */
public class Solution {
    public int maxProduct(int[] nums){


        if(nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        int[][] dp = new int[nums.length][2];
        //dp[i][0]最小值
        //dp[i][1]最大值
       dp[0][0] = nums[0];
       dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++){
           if(nums[i]>=0){
               dp[i][0] = Math.min(nums[i], nums[i]*dp[i-1][0]);
               dp[i][1] = Math.max(nums[i], nums[i]*dp[i-1][1]);
           }else{
               dp[i][0] = Math.min(nums[i], nums[i]*dp[i-1][1]);
               dp[i][1] = Math.max(nums[i], nums[i]*dp[i-1][0]);
           }
           max = Math.max(dp[i][1], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2,4};
        System.out.println(solution.maxProduct(nums));
    }
}
