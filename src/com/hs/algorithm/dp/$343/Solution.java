package com.hs.algorithm.dp.$343;

/**
 * TODO
 * LC 343 整数分解，使得乘积最大
 * https://leetcode-cn.com/problems/integer-break/solution/bao-li-sou-suo-ji-yi-hua-sou-suo-dong-tai-gui-hua-/
 * @author hushe
 * @date 2020/4/25/0025 20:27
 * @email husheng3921@163.com
 */
public class Solution {

    /**
     * 暴力搜索，分解
     * @param n
     * @return
     */
    public int integerBreak1(int n) {
        if (n == 2){
            return 1;
        }
        int res = -1;
        for (int i = 1; i <= n-1; i++) {
            res = Math.max(Math.max(i * (n-i), i * integerBreak1(n-i)), res);
        }
        return res;
    }

    /**
     * 记忆化 搜索
     */
    int[] memory;
    public int integerBreak2(int n) {
        memory = new int[n + 1];
        return integerBreakHelper(n);
    }
    public int integerBreakHelper(int n) {
        if (n == 2) {
            return 1;
        }
        //初始值为0，不为0已经计算，直接返回
        if (memory[n] != 0){
            return memory[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n-i), i * integerBreakHelper(n-i)));
        }
        memory[n] = res;
        return res;
    }

    public int integerBreak3(int n) {

        memory[2] = 1;
        for (int i = 3; i <= n; i++){
            for (int j = 1; j <= i - 1; j++) {
                memory[i] = Math.max(memory[i], Math.max(j * (i - j), j * memory[i-j]));
            }
        }
        return memory[n];
    }
    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.integerBreak1(10));
        System.out.println(ss.integerBreak2(10));
        System.out.println(ss.integerBreak3(10));
    }
}
