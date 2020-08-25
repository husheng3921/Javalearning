package com.hs.algorithm.nowcoder.Test1;

import java.util.Scanner;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/15 13:43
 */
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i< n; i++){
            nums[i] = s.nextInt();
        }
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i< n; i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
