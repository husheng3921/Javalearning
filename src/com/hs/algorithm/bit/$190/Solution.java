package com.hs.algorithm.bit.$190;

/**
 * TODO
 * LC190 32位无符号数字位颠倒
 * @author hushe
 * @date 2020/5/1/0001 8:09
 * @email husheng3921@163.com
 */
public class Solution {
    public int solve(int n){
        int res = 0;
        int curs= 0;
        for (int i = 0; i < 32; i++){
            curs = n&1;//获取最低位是1还是0
            res = res + (curs<<(31-i));//直接将该位的值移到31-i处
            n = n >> 1;//然后右移1位更新数据
        }
        return res;
    }
}
