package com.hs.algorithm.dp.greedy.$56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * LC56 合并区间
 * @author hushe
 * @date 2020/5/7/0007 12:00
 * @email husheng3921@163.com
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
       /* Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[0];
            }
        });*/
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        List<int[] > res = new LinkedList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            int[] last = res.get(res.size() - 1);
            if (curr[0] <= last[1]){
                last[1] = Math.max(last[1], curr[1]);
            }else{
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
