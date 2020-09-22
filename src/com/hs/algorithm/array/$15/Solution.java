package com.hs.algorithm.array.$15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/20 15:42
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            //连续两个数相等
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i +1, right = nums.length - 1;
            while (left < right){
                if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(left);
                    tmp.add(right);
                    res.add(tmp);
                    while (left < right && nums[left] == nums[left++]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right--]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
