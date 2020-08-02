package com.hs.algorithm.binary.$69;

/**
 * https://leetcode-cn.com/problems/sqrtx X的平方根简单
 */
public class LC69 {

    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
        System.out.println(Integer.MAX_VALUE);
        //System.out.println(sqrt2(Integer.MAX_VALUE));
    }
    public static int sqrt(int x){
        long L = 0, R = (long)x;
        long ans = 0;
        while (L <= R){
            long mid = (L + R)/2;
            if( mid * mid <= x){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return (int) ans;
    }
    public static int sqrt2(int x){
        int L = 0, R = x;
        int ans = 0;
        while (L <= R){
            int mid = L + (R-L)/2;
            if( mid * mid <= x){//2147483647/2 * 2147483647/2 溢出大于int范围负数
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        return ans;
    }
}
