package com.hs.algorithm.binary.binsearch;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/30/0030 22:12
 * @email husheng3921@163.com
 */
public class BinSearch {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        BinSearch binSearch = new BinSearch();
        System.out.println(binSearch.searchOne(nums, 8));
        System.out.println(binSearch.searchOne(nums, 8));
        System.out.println(binSearch.searchTwo(nums, 8));
        System.out.println(binSearch.searchTwo(nums, 8));
        System.out.println("***************");
        System.out.println(binSearch.leftBound(nums,8));
        System.out.println(binSearch.rightBound(nums, 8));
        System.out.println(binSearch.lowerBound(nums,8));
    }

    /**
     * 标准二分法查找
     * @param nums
     * @param target
     * @return
     */
    public int binSearch(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left<= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;//直接返回
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        //直接返回
        return -1;
    }

    /**
     * 查找比给定target小的下标最大元素，也就是leftBound - 1;
     * @param a
     * @param target
     * @return
     */
    public int lowerBound(int[] a, int target){
        int left = 0;
        int right = a.length - 1;
        int lastPos = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (a[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
                lastPos = mid;
            }
        }
        return lastPos;
    }

    /** 变形1
     * 寻找相等的元素左边界
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int[] nums, int target){
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
                right = mid -1;
            }
        }
        if (left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    /** 变形2
     * 查找第一个不小于目标值得数
     * @param nums
     * @param tagert
     * @return
     */
    public int searchOne(int[] nums, int tagert){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){ //left = right +1
            int mid = left + (right - left)/ 2;
            if (tagert > nums[mid]){
                left = mid + 1;
            }else if (tagert < nums[mid]){
                right = mid-1;
            }else if (tagert == nums[mid]){
                right = mid-1;//相等继续向左搜索，锁定右边界
            }
        }
        return left;
    }

    /**
     * 变形3寻找右边界
     * @param nums
     * @param target
     * @return
     */
   public int rightBound(int nums[], int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                //别返回，锁定右侧边界
                left = mid + 1;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }
        }
        //最后要检查right越界情况
        if(right < 0 || nums[right] != target){
            return -1;
        }

        return right;
    }

    /** 变形4
     * 查找第一个大于目标的数
     * @param nums
     * @param target
     * @return
     */
    public int searchTwo(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/ 2;
            if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                right = mid -1;
            }else if (target == nums[mid]){
                left = mid + 1;
            }
        }
        return left;
    }


}
