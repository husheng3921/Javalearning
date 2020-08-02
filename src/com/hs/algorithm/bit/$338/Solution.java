package com.hs.algorithm.bit.$338;

/**
 * TODO
 * LC 338 比特位计数，0<=i<=nums,范围中每个数字i中二进制出现i的次数
 * @author hushe
 * @date 2020/4/30/0030 23:05
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * X&(X-1)是将X的最低位1去掉，意思就是 x 的数与 X&(X-1)相差1
     * @param n
     * @return
     */
    public int[] countBits(int n){
        int[] res = new int[n + 1];//0-n,n+1个数 res[i]表示i二进制中1的个数
        for (int i = 1; i <= n;i++){
            res[i] = res[i&(i-1)] + 1;
        }
        return res;
    }

    public int[] countBitsII(int n){
        int[] res = new int[n + 1];//0-n,n+1个数 res[i]表示i二进制中1的个数
        for (int i = 1; i <=n;i++){
            res[i] = res[i>>1] + (i&1);//i>>1,右移1位，判断移走的位是1还是0
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.countBits(5);
        int[] resII = solution.countBitsII(5);
        for (int item : res){
            System.out.print(item + " ");
        }
        System.out.println();
        for (int item : resII){
            System.out.print(item + " ");
        }
    }
}
