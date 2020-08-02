package com.hs.algorithm.binary.$33;

/**
 * TODO
 * LC33 搜索旋转排序数组
 * 核心思路：二分法，找到中间点，同时通过端点值判断两边，那边是有序的
 * @author hushe
 * @date 2020/5/1/0001 9:40
 * @email husheng3921@163.com
 */
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0]==target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[left] <= nums[mid]){//left-mid有序升序
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && nums[right]>= target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
    public int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0]==target ? 0 : -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){//left-mid有序升序
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && nums[n-1]>= target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,5,6,7,0,1,1,2};
        int  target = 1;
        Solution solution = new Solution();
        int res0 = solution.search(nums, target);
        System.out.println(res0);
        int res = solution.search2(nums, target);
        System.out.println(res);
    }
}
