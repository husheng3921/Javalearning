package com.hs.algorithm.dp.greedy.$986;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * LC 986 区间列表的交集问题 中等
 * @author hushe
 * @date 2020/5/7/0007 11:36
 * @email husheng3921@163.com
 */
public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[] > res = new ArrayList<>();

        while (i < A.length && j < B.length){
            int a1 = A[i][0], a2 = A[i][1];
            int b1 = B[j][0], b2 = B[j][1];
            if (a1 <= b2 && a2 >= b1){
                int[] cur = new int[]{Math.max(a1,b1), Math.min(a2,b2)};
                res.add(cur);
            }
            if (a2 > b2){
                j++;
            }else{
                i++;
            }
        }
        return  res.toArray(new int[res.size()][]);

    }
}
