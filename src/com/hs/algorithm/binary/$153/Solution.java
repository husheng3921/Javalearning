package com.hs.algorithm.binary.$153;

/**
 * TODO
 * LC153 寻找旋转排序数组中的最小值 中等,无重复数组
 * @author hushe
 * @date 2020/5/1/0001 10:01
 * @email husheng3921@163.com
 */
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (right == 0) return nums[0];
        if (nums[right] > nums[0]){
            return nums[0];
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
           if (nums[0] < nums[mid]){//前半部有序
               left = mid + 1;
           }else{
               right = mid - 1;
           }
        }
        return -1;

    }
    public int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (right == 0) return nums[0];
        if (nums[right] > nums[0]){
            return nums[0];
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if (nums[left] < nums[mid]){//前半部有序
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        Solution solution = new Solution();
        int res = solution.findMin(nums);
        System.out.println(res);
        int res1 = solution.findMin1(nums);
        System.out.println(res1);
    }
}
