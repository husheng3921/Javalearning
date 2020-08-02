package com.hs.algorithm.dp.greedy.$45;

import java.util.Arrays;

/**
 * TODO
 * LC45 困难 跳跃游戏II
 * @author hushe
 * @date 2020/5/2/0002 15:44
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 定义状态dp[i]表示跳到下标为i的位置最少需要几次跳跃
     * 初始化状态:因为这边涉及到比较 因此对所有的下标位设置一个不可能到达的值 nums.length + 1
     * 状态转移方程: dp[i] = Math.min(dp[j]+1,dp[i]);其中dp[j]表示从下标[0,i)中能够能够走到位置i的所有情况
     * @return
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,nums.length + 1);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] + j >=i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    /**
     * 贪心
     * @param nums
     * @return
     */
    public int jump1(int[] nums){
        int start = 0;
        int end = 1;
        int count = 0;
        while (end < nums.length){
            int maxPos = 0;
            for (int i = start; i < end; i++){
                //能跳到最远的距离
                maxPos = Math.max(maxPos, i+ nums[i]);
            }
            start = end;//下一次起跳点范围开始的格子
            end = maxPos + 1;//下一次调点范围结束的格子
            count ++;//跳跃次数
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution solution = new Solution();
        System.out.println(solution.jump1(nums));
    }
}
