package com.hs.algorithm.sort.$215;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * TODO
 * LC215 中等
 * @author hushe
 * @date 2020/4/29/0029 0:18
 * @email husheng3921@163.com
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length - k];
    }


    public int findKthLargest1(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k-1];
    }

    public void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int mid = partition1(nums,left, right);
        quickSort(nums,left, mid - 1);
        quickSort(nums,mid + 1, right);
    }
    public int partition(int[] nums, int left, int right) {
        int pivot = left;//基准值
        int counter = left;//a[left..counter-1]> a[counter] > a[counter+1,..right]
        for (int i = left + 1; i <= right; i++){
            if (nums[i] > nums[pivot]){
                    int tmp = nums[i];
                    nums[i] = nums[counter+1];
                    nums[counter+1] = tmp;
                    counter++;
            }
        }
        int tmp = nums[pivot];
        nums[pivot] = nums[counter];
        nums[counter] = tmp;
        return counter;

    }
    public int partition1(int[] nums, int left, int right) {
        int pivot = right;//选择最后一个作为基准值
        int j = left;
        for (int i = left; i < right; i++){//不取等号是因为，nums[right]是基准值
                if (nums[i] > nums[pivot]){
                    //大于则排前，降序排列
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
        }
        //找到基准值得正确位置,交换后确保a[l...j-1] > a[j] > a[j+1...r]
        int tem = nums[j];
        nums[j] = nums[pivot];
        nums[pivot] = tem;
        return j;
    }

    public static void main(String[] args) {
        int [] nums = {6, 1, 3, 5, 7, 2, 4, 9, 11, 8};
        Solution solution = new Solution();
        int res = solution.findKthLargest2(nums, 2);
        System.out.println(res);
        for (int num : nums){
            System.out.print(num+"-");
        }
    }

    public  int findKthLargest2(int[] nums, int k){
        int length = nums.length;
        int left = 0, right = length - 1;
        while (true){
            int partion = partition2(nums, 0, length -1);
            if (k == partion+1){
                return nums[partion];
            }else if(k > partion+1){
                left = partion + 1;
            }else {
                right = partion - 1;
            }
        }
    }
    private int partition2(int[] nums, int left, int right){
        if (left < right){
            int random = left + new Random().nextInt(right - left);
            swap(nums, random, right);
        }
        int i = left;
        int pivot = right;
        for (int j = left; j < right; j++){
            if (nums[j] > nums[pivot]){
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, i, pivot);
        return i;
    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
