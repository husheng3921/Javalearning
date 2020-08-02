package com.hs.algorithm.maps.$18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC18 medium
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //定义返回结果
        List<List<Integer>> reslut = new ArrayList<>();
        //当元素个数小于4个时，直接返回
        if(nums == null || nums.length <4){
            return  reslut;
        }
        //对数组进行排序
        Arrays.sort(nums);
        //
        int length = nums.length;
        //定义四个指针i,j,L,R，i从0开始遍历，j从i+1遍历，留下L和R,L指向j+1,R指向右边值最大位置
        for(int i = 0; i < length-3; i++) {//i后面还留3个元素
            //当i处的值与前面相等，跳过
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //获取最小值,如果大于目标值则后面的数都不用考虑
            int minValue = nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(minValue > target){
                break;
            }
            //最大值小于target
            int maxValue = nums[length-1]+nums[length-2]+nums[length-3]+nums[length-4];
            if(maxValue < target ) {
                break;
            }
            //第二层循环
            for(int j = i +1; j<length-2;j++) {//j后面留2个元素
                if( j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                //定义指针L
                int L = j +1;
                int R = length -1;
                //获取当前最小值
                int min = nums[i]+nums[j]+nums[L]+nums[L+1];
                if(min > target){
                    continue;//最小值大于目标值，无需后续工作
                }
                int max = nums[i] + nums[j] + nums[R-1]+nums[R];
                if(max < target){
                    continue;//最大值小于目标值，后面无戏，break
                }
                //开始双指针的表演
                while (L < R) {
                    int cur = nums[i] + nums[j] + nums[L] +nums[R];
                    if(cur == target) {
                        reslut.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        while (L < R && nums[L] == nums[L+1]){
                            L++;
                        }
                        while (L < R && nums[R] == nums[R-1]){
                            R--;
                        }
                        L++;
                        R--;
                    }else if( cur > target){
                        R--;
                    }else{
                        L++;
                    }
                }
            }
        }
        return reslut;
    }
}
