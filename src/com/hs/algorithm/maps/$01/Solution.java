package com.hs.algorithm.maps.$01;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode01 easy
 */
public class Solution {
    /**
     * 暴力法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+ 1; j < nums.length;j++){
                if(nums[i] + nums[j] == target ){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i <nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{ map.get(target - nums[i]),i};
            }else{
                map.put(nums[i], i);
            }
        }

        return null;
    }

}
