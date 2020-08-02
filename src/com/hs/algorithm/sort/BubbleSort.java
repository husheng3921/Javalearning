package com.hs.algorithm.sort;

/**
 * TODO
 * 冒泡排序
 * 算法描述：
 * 1.比较相邻元素，第一个比第二个大，就交换它们两个(升序)
 * 2.对每一对相邻元素做同样的工作，从开始一对到结尾最后一对，这样在最后的元素应该会是最大的数；
 * 3.针对所有元素重复以上步骤，除了最后一个；
 * 4.重复1-3，直到排序完成
 * 时间复杂度O(n^2) 空间复杂度O(1) 稳定
 * @author hushe
 * @date 2020/4/26/0026 18:47
 * @email husheng3921@163.com
 */
public class BubbleSort {
    public void bubbleSort(int[] nums) {
        //两两比较需循环n-1 次 nums.length-1
        for (int i = 0; i < nums.length - 1; i++) {
           //每次冒泡的结果是，依次最后的元素是升序的
            for (int j = 0; j < nums.length - i - 1; j++) {
                //每一趟对比，次最后一个元素就是最大的
                if (nums[j] > nums[j + 1]){//相邻元素两两对比
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSort(int[] a, int n){
        if (n <= 1){
            return;
        }
        for (int i = 0; i < n; i++) {
            //提前退出标记
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++){
                if (a[j] > a[j+1]){
                    //交换，升序
                    swap(a, j, j +1);
                    flag = true;//表示有数据交换
                }
            }
            if (!flag) break;//没有数据交换，则提前退出
        }
    }

    public void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
        BubbleSort bb = new BubbleSort();
        bb.bubbleSort(nums, nums.length);
        for (int num : nums)
            System.out.print(num +" ");
    }
}
