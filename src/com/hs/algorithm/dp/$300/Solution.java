package com.hs.algorithm.dp.$300;

import java.util.Arrays;

/**
 * TODO
 * LC300 最长递增子序列
 * 定义dp[i]为考虑前i个元素，以第i个元素结尾的最长子序列的长度，注意nums[i]必取
 * 我们从小到大计算dp[]数组的值，计算dp[i]之前，我们已计算dp[0~i-1]的值，状态转移方程
 * dp[i] = max(dp[j])+1,其中0<=j<i且nums[j]<nums[i]
 * LISlength = max(dp[i]) 其中0<=i<n；
 * 初始化dp[i] = 1;1个字符显然长度1的升序列 原始数组为降序序列时候，每个i字符结尾，1个字符
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/
 * @author hushe
 * @date 2020/4/20/0020 9:58
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * O(N^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //dp[0] = 1;
        int maxAns = 1;
        for(int i = 1; i<nums.length; i++) {
            int max = 0;
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]); // dp[i] = Math.max(dp[i],dp[j]+1);
                    dp[i] = max + 1;
                }
            }

            maxAns = Math.max(maxAns, dp[i]);
        }
        //String str ="444";
        return maxAns;
    }


}
