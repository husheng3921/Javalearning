package com.hs.algorithm.test;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/6/0006 9:10
 * @email husheng3921@163.com
 */
public class MergeSort {

    //归并排序，递归
    public void mergeSort(int[] nums, int left, int right){
        //递归结束条件
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;//分治
        mergeSort(nums, left, mid);//递归
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);//合并mid两边的有序数组
    }
    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//用来合并存放有序数组
        int i = left, j = mid + 1, k = 0;//定义移动指针
        //合并两个有序数组成一个数组
        while(i <=mid && j <= right){
            //升序排序
            if(nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        //判断哪个子数组有剩余并循环复制
        while (i <= mid){
            temp[k++] = nums[i++];
        }
        while (j <= right){
            temp[k++] = nums[j++];
        }
        //合并后的有序数组还原到旧数组
        for(int p = left; p <= right; p++) {
            nums[p] = temp[p - left];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
        MergeSort ms = new MergeSort();
        ms.mergeSort(nums,0,nums.length-1);
        for (int num : nums){
            System.out.print(num+" ");
        }
    }
}
