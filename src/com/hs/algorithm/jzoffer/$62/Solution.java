package com.hs.algorithm.jzoffer.$62;

/**
 * Created by husheng02.
 * 圆圈中最后剩下的数字
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/12 13:57
 */
public class Solution {
    /**
     * O(n) O(1)
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m){
        int ans = 0;
        //最后一轮剩下2个人，从2开始反推
        for (int i = 2; i <= n; i++){
            ans = (ans + m) % i;
        }
        return ans;
    }
}
