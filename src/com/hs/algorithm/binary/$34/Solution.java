package com.hs.algorithm.binary.$34;

/**
 * TODO
 * LC34 排序数组，左边界和右边界
 * @author hushe
 * @date 2020/5/5/0005 20:21
 * @email husheng3921@163.com
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target, true);
        int right = leftBound(nums, target, false) - 1;
        if (left >= nums.length || nums[left] != target){
            return new int[]{-1,-1};
        }
        return new int[]{left, right};
    }

    public int leftBound(int[] nums, int target, boolean flag){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                right = mid - 1;
            }else if (target == nums[mid]){
                //别返回，锁定左侧边界
                if (flag){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }

        return left;
    }
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target = 8;
        int left = (new Solution()).leftBound(nums, target, true);
        int right = (new Solution()).leftBound(nums, target, false) - 1;
        System.out.println(left+"***"+right);
    }
}
