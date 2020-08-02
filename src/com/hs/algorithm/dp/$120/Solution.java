package com.hs.algorithm.dp.$120;

import java.util.List;

/**
 * TODO
 * LC 120 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/solution/javadong-tai-gui-hua-si-lu-yi-ji-dai-ma-shi-xian-b/
 * @author hushe
 * @date 2020/4/25/0025 19:02
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 自顶向下 O(N^2) O(N^2)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;//

        for (int i = 1; i < m; i++) {
            //对每一行的元素推导
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    //最左端特殊处理
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                }else if (j == i){
                    //最右端特殊处理
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }
        //最后一行选最小的
        for (int i = 0; i < n;i++){
            res = Math.min(res,dp[m-1][i]);
        }
        return res;
    }

    /**
     * 自底向上
     * @param triangle
     * @return
     */
    public int minmumTotal1(List<List<Integer>> triangle) {
        //特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        //
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >=0; i--){
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + rows.get(j);
            }
        }
        return dp[0];
    }

    /**
     * 自底向上
     * @param triangle
     * @return
     */
    public int minmumTotal2(List<List<Integer>> triangle) {
        //特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()+1][triangle.get(triangle.size()-1).size()+1];
        for (int i = triangle.size()-1; i >=0 ; i--){
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Solution ss = new Solution();

    }
}
