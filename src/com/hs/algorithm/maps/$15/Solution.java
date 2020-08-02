package com.hs.algorithm.maps.$15;

import java.util.*;

/**
 *LeetCode 15 三数之和 medium
 */
public class Solution {
    /**
     * 没法通过
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>();
                int c = -(nums[i] + nums[j]);
                if(set.contains(c) ){
                    list.add(c);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    lists.add(list);
                }else {
                    set.add(nums[i]);
                    set.add(nums[j]);
                }
            }
        }

        return lists;
    }

    /**
     * 双指针，排序，根据有序单调性缩小区间查找，
     * 先确定第一个数，再在后面有序区间，两头缩进确定另外两个数，前面时间复杂度O(N),细节在于去重
     * 时间复杂度O(N^2),排序O(NlogN),双指针遍历O(N^2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);//排序
        for(int i = 0; i < nums.length-2; i++) {
            //如果小数字大于0，三个数字和必大于0，退出循环
            if(nums[i] > 0){
                break;
            }
            //和为0的三个数，相同值只遍历一次
            if( i >0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i + 1;
            int R = nums.length -1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    lists.add( Arrays.asList(nums[i], nums[L], nums[R]));
                    //和为0 的三个数，相邻相同的只遍历一次
                    while(L < R && nums[L] == nums[L+1]){
                        L++;
                    }
                    while (L < R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    //取完一组和为0的三个数，两个指针同时移动
                    L++;
                    R--;
                }else if( sum < 0){
                    //如果sum<0,则移动左指针
                    L++;
                }else{
                    //sum >0,R--
                    R--;
                }
            }
        }
        return lists;
    }
}
