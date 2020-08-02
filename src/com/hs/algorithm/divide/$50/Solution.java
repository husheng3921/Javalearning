package com.hs.algorithm.divide.$50;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/7/0007 8:56
 * @email husheng3921@163.com
 */
public class Solution {
    public double myPow(double x, int n){
        long N = n;
        if(N < 0){
            N = -N;
            x= 1/x;
        }
        return fastPow(x,n);
    }
    private double fastPow(double x, long n){
        if(n == 0) {
            return 1;
        }
        double half = fastPow(x, n/2);
        if(n % 2==0){
            return half * half;
        }else{
            return half * half * x;
        }
    }
}
