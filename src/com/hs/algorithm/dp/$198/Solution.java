package com.hs.algorithm.dp.$198;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/18/0018 20:47
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 偷窃第K间屋，不偷k-1, 则金额为k-2 + nums[k]
     * 不偷窃k间屋，则偷K-1，金额为k-1
     * 即结果为 dp[k] = max(dp[k-1],dp[k-2]+nums[k])
     * O(n) O(n)
     * @param nums
     * @return
     */
    public int rob(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[length -1];
    }
    public int rob1(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if (length == 1){
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i =2; i < length; i++){
            int temp = second;
            second = Math.max(first + nums[i],second);
            first = temp;
        }
        return second;
    }
}
