package com.hs.algorithm.dp.greedy.$55;

import javax.sound.midi.Soundbank;

/**
 * TODO
 * LC55 跳跃游戏 中等
 * @author hushe
 * @date 2020/5/2/0002 12:02
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 贪心 O(n) O(1)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){
        if (nums == null) return false;
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >=0; i--){
            if (nums[i] + i >= endReachable){
                endReachable = i;
            }
        }
        return endReachable == 0;
    }

    /** dp[i]： 指从0走到i后的下一个最大能走到的下标（前i+1个元素能到达的最远的下标）
     对数组从前往后操作
     边界条件： dp[0] = nums[0]
     dp[i]转化条件：如果 i 可达, 更新 dp[i] = max(dp[i-1], i + nums[i]), 不可达return False
     复杂度为 O(n)
     * 动态规划
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums){
        if (nums == null) return false;
        if (nums.length == 1) return true;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if (i > dp[i-1]){
                return false;//第i个走不到
            }else{
                dp[i] = Math.max(dp[i-1], i + nums[i]);
                if (dp[i] >= nums.length - 1){
                    return true;//走到末尾
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums ={2,3,1,1,4};
        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));
        System.out.println(solution.canJump1(nums));
    }
}
