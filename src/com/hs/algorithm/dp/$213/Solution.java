package com.hs.algorithm.dp.$213;

/**
 * TODO
 * 打家劫舍II 中等
 * 可以偷第一家和偷最后一家两种情况分析
 * @author hushe
 * @date 2020年9月7日, 0007 16:56
 * @email husheng3921@163.com
 */
public class Solution {
    public int rob(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(rob(nums,0, nums.length-2),rob(nums,1,nums.length - 1));
    }

    /**
     *
     * @param nums
     * @param i 起始索引
     * @param j 终止索引
     * @return
     */
    private int rob(int[] nums, int i, int j){
        int first = 0, second = 0, tmp;
        for(int k = i; k <= j; k++){
            tmp = second;
            second = Math.max(first + nums[k], second);
            first = tmp;
        }
        return second;
    }
}
