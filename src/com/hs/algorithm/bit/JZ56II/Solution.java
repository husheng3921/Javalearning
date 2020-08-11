package com.hs.algorithm.bit.JZ56II;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 17:05
 */
public class Solution {
    public int[] singleNumbers(int[] nums){
        int sum = 0;
        //将所有元素进行两两异或，0与任何数异或都是任何自己
        for(int i = 0; i < nums.length; i++){
            sum ^= nums[i];
        }
        int first = 1;
        while ((sum & first) == 0){
            first = first << 1;
        }
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            //分组
            if((nums[i] & first) == 0){
                result[0] ^= nums[i];
            }else{
                result[1] ^=nums[i];
            }
        }
        return result;
    }
    public int singleNumber(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums){
            int count = map.getOrDefault(e, 0) +1;
            map.put(e, count);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
