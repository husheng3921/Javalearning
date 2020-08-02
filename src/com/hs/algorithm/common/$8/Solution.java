package com.hs.algorithm.common.$8;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 12:29
 * @email husheng3921@163.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "-000000000000001";
       int res =  solution.myAtoi(str);
        System.out.println(res);
    }

    /**
     * 用负边界，负数[-2^31,2^31-1],min乘以-1，越界，用max*-1，取负边界
     * @param str
     * @return
     */
    public int myAtoi(String str){
        char[] chars = str.toCharArray();
        int n = str.length();
        int idx = 0;
        while (idx < n && chars[idx] == ' '){
            idx++;//忽略空格
        }
        if(idx == n){
            //去除空格后，到末尾
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        }else if (chars[idx] == '+'){
            idx++;//正号
        }else if(!Character.isDigit(chars[idx])){
            //不是数字或符号
            return 0;
        }
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        long limit = negative ? min : -max;//用于判断越界.-1*min正数越界，用正数的负边界
        int res = 0;
        while (idx < n && Character.isDigit(chars[idx])){
            int digit = chars[idx] - '0';
            if (res < (limit + digit)/10){
                return negative ? min : max;
            }
            res = res * 10 - digit;
            idx++;
        }
        return negative? res : -res;

    }
}
