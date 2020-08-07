package com.hs.algorithm.sort;

/**
 * TODO
 * 时间复杂度 均为O(nlogn) 空间复杂度O(1) 不稳定
 * @author hushe
 * @date 2020/4/26/0026 21:09
 * @email husheng3921@163.com
 */
public class HeapSort {
    public void headSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--){
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    public void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
           swap(array,largest,i);
            heapify(array, length, largest);
        }
    }
    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
        HeapSort hs = new HeapSort();
        hs.headSort(nums);
        for (int num : nums){
            System.out.print(num +" ");
        }

    }
}
