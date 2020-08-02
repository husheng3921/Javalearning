package com.hs.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/29/0029 9:23
 * @email husheng3921@163.com
 */
public class So429 {
    public int maxSum(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()+1][triangle.get(triangle.size()-1).size()+1];
        for (int i = triangle.size()-1; i >=0 ; i--){
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(8);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(8);
        List<Integer> list3 = new ArrayList<>();
        list3.add(8);
        list3.add(1);
        list3.add(0);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(7);
        list4.add(5);
        list4.add(4);
        List<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(5);
        list5.add(2);
        list5.add(6);
        list5.add(5);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        lists.add(list5);
        System.out.println((new So429()).maxSum(lists));
    }
}
