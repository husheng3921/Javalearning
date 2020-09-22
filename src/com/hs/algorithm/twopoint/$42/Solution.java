package com.hs.algorithm.twopoint.$42;

/**
 * Created by husheng02.
 * 接雨水
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/12 15:01
 */
public class Solution {
    public int trap(int[] height){
        int left = 0, right = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right){
            if (height[left] < height[right]){
                if(leftMax <= height[left]){
                    leftMax = height[left];
                }else {
                    res += leftMax - height[left];
                }
                left++;
            }else {
                if (rightMax <= height[right]){
                    rightMax = height[right];
                }else {
                    res += rightMax - height[right];
                }
                right--;
            }

        }
        return res;
    }
}
