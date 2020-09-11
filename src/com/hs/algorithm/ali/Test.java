package com.hs.algorithm.ali;

import java.util.*;

/**
 * TODO
 *
 * @author hushe
 * @date 2020年8月25日, 0025 14:44
 * @email husheng3921@163.com
 */
public class Test {
    private List<List<Integer>> res = new LinkedList<>();
    public static void main(String[] args) {
        Test test = new Test();
        int[] nums={1, 2, 3, 8};

        List<List<Integer>> res = test.solution(nums, 3);
        System.out.println(res.size());
        System.out.println(test.solution(3, nums));
        System.out.println(test.solution1(3, nums));
    }

    public List<List<Integer>> solution(int[] nums, int n){
        Arrays.sort(nums);
        Stack<Integer> track = new Stack<>();
        dfs(nums, n,0, track);
        return res;
    }
    private void dfs(int[] nums,int n,int k,Stack<Integer> track){
        if(n == 0){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] > n){
                continue;
            }

            track.push(nums[i]);
            dfs(nums,n - nums[k],k+1,track);
            track.pop();
        }

    }
    public int solution(int n, int[] coins){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int coin : coins){
            for (int i = coin; i <=n; i++){
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        return dp[n];
    }
    private int solution1(int target, int[] nums){
        //dp[i][j]表示选用前i种硬币凑成j元的情况数
        int[][] dp = new int[nums.length+1][target+1];
        //base
        for (int i = 0; i <= nums.length; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++){
            for (int j = 1; j <= target; j++){
                if (nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-nums[i-1]];
                }else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
