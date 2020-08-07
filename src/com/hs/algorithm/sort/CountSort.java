package com.hs.algorithm.sort;

import java.util.Arrays;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/05 16:43
 */
public class CountSort {
    public static int[] countSort(int[] array){
        //得到数组的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        //根据数组的最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        //遍历数组，填充统计数组
        for(int i = 0; i < array.length; i++){
            countArray[array[i]]++;
        }
        //遍历统计结果，输出结果
        int index = 0;
        int[] sortArray = new int[array.length];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < countArray[i]; j++){
                sortArray[index++]=i;
            }
        }
        return sortArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        //int[] result = countSort(array);
        countingSort(array, array.length);
        System.out.printf(Arrays.toString(array));
    }

    public static void countingSort(int[] a, int n){
        if (n <= 1) return;
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
            }
            if (a[i] < min){
                min = a[i];
            }
        }
        //根据数组的最大与最小差值确定统计数组的长度
        int d = max - min;
        int[] c = new int[d + 1];
        //遍历数组，填充统计数组
        for(int i = 0; i < a.length; i++){
            c[a[i] - min]++;
        }
        //依次累加
        for(int i = 1; i <= d;i++){
            c[i] += c[i-1];
        }

        int [] r = new int[n];
        //倒序遍历数组，从统计数组找到正确位置，输出结果数组
        for (int i = n - 1; i >=0; i--){
            int index = c[a[i] - min] -1;
            r[index] = a[i];
            c[a[i] - min]--;
        }
        for(int i = 0; i < n; i++){
            a[i] = r[i];
        }
    }
}
