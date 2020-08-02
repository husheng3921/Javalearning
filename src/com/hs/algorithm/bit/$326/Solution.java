package com.hs.algorithm.bit.$326;

/**
 * TODO
 * LC326 3的幂
 * @author hushe
 * @date 2020/4/25/0025 17:03
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0){
            return false;
        }
        while (n != 1){
            if (n % 3 != 0){
                return false;
            }else{
                n = n/3;
            }
        }
        // 1直接返回true，
        return true;
        /** if(n<1) return false;
         *  while(n % 3 == 0){
         *      n /=3;
         *   }
         *  return n == 1;
         */
    }
    public boolean isPowerOfThree1(int n){
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree1(1));
        System.out.println(solution.isPowerOfThree1(9));
        System.out.println(solution.isPowerOfThree(3));
        System.out.println(solution.isPowerOfThree1(6));
        System.out.println(solution.isPowerOfThree1(45));
    }
}
