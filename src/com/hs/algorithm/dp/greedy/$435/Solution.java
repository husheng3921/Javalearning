package com.hs.algorithm.dp.greedy.$435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO
 *https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484493&amp;idx=1&amp;sn=1615b8a875b770f25875dab54b7f0f6f&source=41#wechat_redirect
 * @author hushe
 * @date 2020/4/23/0023 18:14
 * @email husheng3921@163.com
 */
public class Solution {

    public static void main(String[] args) {
        int[][] ints ={{1,2},{2,3},{3,4},{1,3}};
        int res = (new Solution()).eraseOverlapIntervals(ints);
        System.out.println(res);
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalSchedule(intervals);
    }

    /**
     * 时间复杂O(nlogn)排序
     * @param intvs
     * @return
     */
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //至少有一个区间不想交
        int count = 1;
        //排序后，第一个区间x
        int xEnd = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= xEnd) {
                count++;
                xEnd = interval[1];
            }
        }
        return count;
    }


}
