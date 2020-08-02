package com.hs.algorithm.bit.$191;

/**
 * TODO
 * LC191 位1的个数
 * @author hushe
 * @date 2020/5/1/0001 8:13
 * @email husheng3921@163.com
 */
public class Solution {
    public int solveOne(int n) {
        int bits = 0;
        while (n != 0){
            if (n % 2 == 1){
                bits++;
            }
            n = n >>1;//n/2
        }
        return bits;
    }

    public int solveTwo(int n){
        int curs = 0;
        int bits = 0;
        for (int i = 0; i < 32; i++){
            curs = n&1;//获取最低位
            if (curs != 0){
                bits++;
            }
            n = n >> 1;//n向右移1位
        }
        return bits;
    }
    /**
     * 采用掩码的思想，
     * 0000 0001 第0位为1
     * 0000 0010 第1位为1
     * 掩码每次左移1
     * 时间复杂度O(1) 32位整数，最多比较32次
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public int solveThree(int n){
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++){
            if ((n & mask)!=0){
                bits++;
            }
            mask = mask<<1;
        }
        return bits;
    }

    /**
     * X=X&(X-1) 清零X的最低位的1
     * @param n
     * @return
     */
    public int solveFour(int n){
        int bits = 0;
        while (n != 0){
            bits++;
            n = n&(n-1);
        }
        return bits;
    }
}
