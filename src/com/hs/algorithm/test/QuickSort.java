package com.hs.algorithm.test;

/**
 * TODO
 * 快排测试
 * @author hushe
 * @date 2020/5/6/0006 9:43
 * @email husheng3921@163.com
 */
public class QuickSort {
    //快排,递归
    public void quickSort(int[] nums, int left, int right) {
        //递归结束条件
        if(left >= right){
            return;
        }
        int position = partition(nums, left, right);//获取基准值
        quickSort(nums, left, position - 1);
        quickSort(nums, position + 1, right);
    }
    //找到基准位置，左边小于基准值右边大于基准值
    public int partition(int[] nums, int left, int right){
        //这里取最后一个作为基准值
        int pivot = right;//nums[pivot]
        int k = left;//标记分界位置
        for(int i = left; i < right; i++){//将基准值前的值都与基准值进行比较
            if(nums[i] < nums[pivot]){
                swap(nums, k, i);//交换顺序，确保分界k处前都比pivot小
                k++;
            }
        }
        swap(nums, k, pivot);//基准值就位a[0-k-1]<a[k]<a[k+1-]
        return k;//返回分界处
    }
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
       QuickSort qq = new QuickSort();
        qq.quickSort(nums, 0, nums.length - 1);
        for (int num : nums)
            System.out.print(num + " ");
    }
}
