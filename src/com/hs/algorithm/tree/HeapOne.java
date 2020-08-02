package com.hs.algorithm.tree;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/4/30/0030 9:20
 * @email husheng3921@163.com
 */
public class HeapOne {
    private int[] a;//用数组来存储，从下标1开始
    private int n;//堆可以存储最大数据个数
    private int count;//堆中已经存储的数据个数

    public HeapOne(int capacity){
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    /**
     * 插入元素构建堆
     * @param data
     */
    public void insert(int data){
        if (count >= n){
            return;//堆满了
        }
        ++count;//从1开始编号，则count对应数组最后一个元素的索引值，
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]){//自底向上堆化
            swap(a, i, i/2);
            i = i/2;
        }
    }

    /**
     * 交换数组中的元素
     * @param a
     * @param x
     * @param y
     */
    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /**
     * 删除堆顶最大元素
     */
    public int removeMax(){
        if (count == 0) return -1;//堆中无元素
        int top = a[1];//暂存堆顶元素
        a[1] = a[count];//堆顶元素等于末尾
        count--;//堆顶元素出堆
        heapfiy(a,count,1);//重新调整堆
        return top;//返回堆顶元素
    }

    /**
     * 堆化调整位置
     * @param a
     * @param n 堆大小
     * @param i 调整元素位置
     */
    private void heapfiy(int[] a, int n, int i){
        //自上往下
        while (true){
            int maxPos = i;
            if (i*2 <= n && a[i] < a[2*i])
                maxPos = 2*i;
            if (i*2+1 <= n && a[maxPos] < a[2*i+1])
                maxPos = i*2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 建堆
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n){
        for (int i = n/2; i >= 1; i--){
            heapfiy(a, n, i);
        }
    }

    /**
     *排序
     * @param a
     * @param n
     */
    public void sort(int[] a, int n){
        buildHeap(a, n);
        int k = n;
        while (k > 1){
            swap(a,1, k);
            --k;
            heapfiy(a, k, 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1, -2, 29, -33, 90, 100, 45, 25};
        HeapOne heap = new HeapOne(nums.length);
        heap.sort(nums, nums.length-1);
        for (int num: nums){
            System.out.print(num + " ");
        }
    }
}
