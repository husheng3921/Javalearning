package com.hs.algorithm.dp.greedy.$455;

import java.util.Arrays;

/**
 * TODO
 * LC455分发饼干 简单
 * @author hushe
 * @date 2020/5/3/0003 9:12
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 暴力循环
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;
        int gIndex = 0, sIndex = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while ( gIndex < gLen && sIndex < sLen){
            if (g[gIndex] <= s[sIndex]){//满足供给需求
                gIndex++;//孩子需求指针向右移动
            }
            sIndex++;
        }
        int i = 0;
        for (int j = 0; i < gLen && j < sLen; j++){
            if (s[j] >= g[i]) i++;
        }
        // return i;
        return gIndex;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3}, s ={3};
        Solution solution = new Solution();
        int res = solution.findContentChildren(g, s);
        System.out.println(res);
    }
}
