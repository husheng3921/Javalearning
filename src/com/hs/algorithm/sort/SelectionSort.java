package com.hs.algorithm.sort;

/**
 * TODO
 * 选择排序
 * 算法描述：
 * 1.初始状态：无序区R[1..n],有序区为空
 * 2.第i排序(i=1,2,3...n-1)开始时，当前有序去和无序区R[1..i-1]和R(i..n).该趟排序从当前无序区中，选出关键字最小的记录R[k]
 * 将它与无序区第一个记录R交换，使R[1..i]和R[i+1...n）记录新增和减少一个
 * 3.n-1趟结束，数组有序化
 * 时间复杂度O(n^2) 空间复杂度O(1)
 * @author hushe
 * @date 2020/4/26/0026 19:03
 * @email husheng3921@163.com
 */
public class SelectionSort {

    public void selectionSort(int[] nums) {

        int minIndex, temp;//标记当前要放置次小值得位置
        //n-1趟排序,i从0-n-2
        for (int i = 0; i < nums.length -1; i++) {
            minIndex = i;
            //循环一次，找到比nums[minIndex]小的数的索引
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]){
                   minIndex = j;
                }
            }
            //将i的值与最小索引值交换，使当前i处依次最小
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
