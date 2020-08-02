package com.hs.algorithm.bit.$231;

/**
 * TODO
 * LC231 判断是否为2的幂 2 4 8 只有是2的n次幂时，减一后，全为1
 * 4 0100  4-1 0011  & 0
 * 6 0110  6-1 0101  & 0100
 * @author hushe
 * @date 2020/4/25/0025 16:57
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n&(n-1))==0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(8));
        System.out.println(solution.isPowerOfTwo(6));
    }
}
