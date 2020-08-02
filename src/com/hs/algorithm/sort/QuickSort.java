package com.hs.algorithm.sort;

/**
 * TODO
 * 快排
 *  数组选取标杆pivot, 将小元素放在pivot左边，大元素方右侧，然后依次对左边和右边的子数组继续快排，以达到整个数组有序
 *  时间复杂度 平均O(nlogn)   最好O(nlogn)   最坏O(n^2)     空间复杂度O(nlogn) 不稳定
 * @author hushe
 * @date 2020/4/26/0026 20:07
 * @email husheng3921@163.com
 */
public class QuickSort {
    public void quickSort(int[] array, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(array, begin, end);
        quickSort(array,begin,pivot-1);
        quickSort(array, pivot + 1, end);
    }

    /**
     *  寻找子数组中，pivot值，在索引pivot左边，元素都比a[pivot]小，右边大
     * @param a
     * @param begin
     * @param end
     * @return
     */
    public int partition(int[] a, int begin, int end){
        //pivot:标杆位置，初始为末尾元素，counter： 小于pivot索引处的元素个数，移动指针标记新pivot位置
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {//i<end 是因为基准值是最后一个不取
            if (a[i] < a[pivot]) {// pivot元素前一一比较，小于则记录
                /*int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;*/
                swap(a, counter, i);
                counter++;
            }
        }
        //开始pivot置于end处，此时counter已经找到pivot分界位置
        //替换a[pivot]与a[counter] 确保a[counter]两侧大小
       /* int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;*/
        swap(a,pivot,counter);
        return counter;//返回分界位置
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }



    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
        QuickSort qq = new QuickSort();
        qq.quickSort(nums, 0, nums.length - 1);
        for (int num : nums)
            System.out.print(num + " ");
    }
}
