package com.hs.algorithm.binary.$50;

/**
 * 50 Pow(x,y) 快速幂  中等
 * x^n = A *A
 * 奇偶单独拿出来，A*A*x
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
