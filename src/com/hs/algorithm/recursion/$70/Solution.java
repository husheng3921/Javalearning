package com.hs.algorithm.recursion.$70;

/**
 * TODO
 * LC70 爬楼梯 简单
 * @author hushe
 * @date 2020/5/5/0005 8:22
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 暴力搜索超时O(2^n) 空间复杂度O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if ( n <= 1){
            return 1;
        }else{
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 记忆化搜索 O(N) O(N)
     * @param n
     * @return
     */
    public int climbStairs1(int n){
        int[] memor = new int[n+1];//0-n,n+1个

        return climb(0,n,memor);

    }
    public int climb(int i, int n, int[] memo){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }
        if (memo[i] > 0){
            return memo[i];
        }
        memo[i] = climb(i+1, n,memo) + climb(i + 2,n,memo);
        return memo[i];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs2(int n){
        int[] memor = new int[n+1];
        memor[0]=memor[1]=1;
        for (int i = 2; i <=n; i++){
            memor[i] = memor[i - 1] + memor[i - 2];
        }
        return memor[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.climbStairs1(3);
        System.out.println(res);
    }
}
