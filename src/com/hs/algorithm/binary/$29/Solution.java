package com.hs.algorithm.binary.$29;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/18/0018 21:26
 * @email husheng3921@163.com
 */
public class Solution {
    public int divide(int dividend, int divisor){
        if (divisor == 0){
            return -1;
        }
        if (dividend == 0){
            return 0;
        }
        //Integer.min
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;//正负最大最小绝对值相差1
        }
        //符号位的处理，异或
        boolean negative = (dividend^divisor)<0;
        long dividendTmp = Math.abs((long)dividend);
        long divisorTmp = Math.abs((long)divisor);
        int res = 0, divCount = 1;

        while (dividendTmp >= divisorTmp){
            dividendTmp -= dividendTmp;
            res += divCount;
            if (dividendTmp < Math.abs(divisor)){

            }
        }
        return res;
    }
}
