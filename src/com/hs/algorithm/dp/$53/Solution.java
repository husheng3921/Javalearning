package com.hs.algorithm.dp.$53;

/**
 * TODO
 * LC53 最大子序和
 *  输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @author hushe
 * @date 2020/5/1/0001 11:23
 * @email husheng3921@163.com
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i],dp[i-1] + nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public int maxSubArray2(int[] nums) {
        //1状态定义，dp[i]表示以i结尾的连续子数组的最大和，
        int[] dp = new int[nums.length];
        //2.状态初始化，
        dp[0] = nums[0];
        int max = dp[0];
        //状态转移方程
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i],dp[i-1] + nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public int maxSubArray1(int[] nums){
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > 0) nums[i] += nums[i-1];
            maxSum = Math.max(maxSum,nums[i]);
        }
        return maxSum;
    }
    public int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        //dp[i]表示以i结尾的元素的子数组最大和
        for(int i = 1; i < nums.length; i++){
            if(dp[i-1]>0){
                dp[i] = nums[i] + dp[i-1];
            }else{
                dp[i] = nums[i];
            }
            //更新最大子数组和
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        int max = solution.maxSubArray2(nums);
        System.out.println(max);
    }
}
