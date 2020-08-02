package com.hs.algorithm.sort;

/**
 * TODO
 * 算法4th 快排算法实现
 *
 * @author hushe
 * @date 2020/4/26/0026 21:27
 * @email husheng3921@163.com
 */
public class QuickSortII {

    public void sort(int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(array, lo, hi);
        sort(array, lo, j-1);
        sort(array, j + 1, hi);
    }

    public int partition(int[] array, int lo, int hi) {
        //将数组切分为a[lo....i-1],a[i],a[i+1...hi]
        int i = lo, j = hi + 1;
        int v = array[lo];//切分元素，暂定为第一个
        while (true) {
            //扫描左右，检查扫描是否结束，并交换元素
            while (array[++i] < v) {//满足
                if (i == hi)
                    break;
            }

            while (v < array[--j]){
                if (j == lo)
                    break;
            }
            if (i >= j){
                break;//找到j分界点跳出循环
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        int temp = array[lo]; //找到j，将v = a[j]放入正确位置
        array[lo] = array[j];
        array[j] = temp;
        return j;// a[lo..j-1] <= a[j] <= a[j+1...hi]
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 29, -33, 90, 100, 45, 25};
        QuickSortII qq = new QuickSortII();
        qq.sort(nums, 0, nums.length - 1);
        for (int num : nums)
            System.out.print(num + " ");
    }
}
