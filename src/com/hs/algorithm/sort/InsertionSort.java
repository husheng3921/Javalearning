package com.hs.algorithm.sort;

/**
 * TODO
 * 插入排序
 * 算法描述：
 * 1.从第一个元素开始，该元素可以认为已经排序
 * 2.取出下一个元素，在已经排序的元素中从后向前扫描
 * 3.如果该元素大于新元素，将该元素移到下一位置
 * 4.重复步骤3，直到找到已排序的元素小于或等于新元素的位置
 * 5.将新元素插入到该位置后
 * 重复步骤2-5
 * 时间复杂度O(N^2) 空间复杂度O(1) 稳定
 * @author hushe
 * @date 2020/4/26/0026 19:20
 * @email husheng3921@163.com
 */
public class InsertionSort {
    public void insertionSort(int[] nums) {
        int preIndex, current;
        for (int i = 1; i < nums.length; i++) {
            preIndex = i - 1;
            current = nums[i];
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
        InsertionSort bb = new InsertionSort();
        bb.insertionSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
