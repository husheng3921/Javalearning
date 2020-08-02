package com.hs.algorithm.sort;

/**
 * TODO
 * 归并排序
 *  归并排序是建立在归并操作上的一种有效排序算法，该算法采用分治法，将已有序的子序列合并，得到完全有序的序列
 *  即先使每个子序列有序，再使每个子序列端间有序，将两个有序表合并，2-路归并
 *  1.将长度为n的输入序列分裂成长度n/2的子序列。
 *  2.对这两个子序列采用归并排序
 *  3.将两个排序好的子序列合并成一个最终排序序列
 *  平均时间复杂度、最好、最坏均为O(nlogn) 空间复杂度O(n) 稳定排序
 * @author hushe
 * @date 2020/4/26/0026 19:51
 * @email husheng3921@163.com
 */
public class MergeSort {
    public void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right-left)>>1);//运算优先级

        mergeSort(array,left, mid);//左半边排序
        mergeSort(array,mid + 1, right);//右半边排序
        merge(array, left, mid, right);//归并结果
    }
    public void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//中间数组
        int i = left, j = mid + 1, k = 0;

        //合并两个有序数组成一个有序的数组
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            temp[k++] = array[i++];//i子数组没有合并完，直接复制过来
        }
        while (j <= right) {
            temp[k++] = array[j++];//j子数组没有合并完，有剩余，直接复制过来
        }
        //合并后的数组赋给原来的数组
        for (int p = 0; p < temp.length; p++) {
            array[left+p] = temp[p];
        }
        //也可以用 System.arraycopy(a, start1, b, start2, length);
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
