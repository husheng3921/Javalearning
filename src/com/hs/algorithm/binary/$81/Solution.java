package com.hs.algorithm.binary.$81;

/**
 * TODO
 * LC81 搜索旋转排序数组II,有重复元素 中等
 * @author hushe
 * @date 2020/5/1/0001 10:26
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        if (n == 1) return nums[0] == target;

        int left = 0;
        int right = n - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[mid]){
                left ++;
                continue;
            }
            if (nums[left] < nums[mid]){//0-mid前半部分有序
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ //后半部分有序
                if (nums[mid] < target && nums[right]>= target){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
       int[] nums = {2,5,6,0,0,1,2};
       int target = 2;
       Solution solution = new Solution();
       boolean res = solution.search(nums, target);
        System.out.println(res);
    }
}
