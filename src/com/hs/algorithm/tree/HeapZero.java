package com.hs.algorithm.tree;

import java.util.Arrays;

/**
 * TODO
 * 堆实现 数组从0开始，左子树2*i+1,右子节点2*i+2,父节点(i-1)/2
 * @author hushe
 * @date 2020/4/30/0030 9:20
 * @email husheng3921@163.com
 */
public class HeapZero {
    private int[] a;//用数组来存储，从下标0开始
    private int n;//堆可以存储最大数据个数
    private int count;//堆中已经存储的数据个数

    public HeapZero(int capacity){
        a = new int[capacity ];
        n = capacity;
        count = 0;
    }
    public HeapZero(int[] nums){
        n = nums.length;
        a = new int[n];
        count = n;
        //拷贝数组
        System.arraycopy(nums,0,a,0,n);
       buildHeap(a,n);//构建堆
    }

    /**
     * 插入元素构建堆,堆尾插入
     * @param data
     */
    public void insert(int data){
        if (count >= n){
            return;//堆满了
        }
        a[count] = data;//从0开始编号，则count-1对应数组最后一个元素的索引值，
        int i = count;
        while ((i-1)/2 > 0 && a[i] > a[(i-1)/2 ]){//自底向上堆化
            swap(a, i, (i-1)/2 );
            i = (i-1)/2 ;
        }
        ++count;
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
        int top = a[0];//暂存堆顶元素
        count--;//堆顶元素出堆
        a[0] = a[count];//堆顶元素等于末尾
        heapfiy(a,count,0);//重新调整堆
        return top;//返回堆顶元素
    }

    /**
     * 堆化调整位置
     * @param a O(logn) 即循环堆的高度logn
     * @param n 堆大小
     * @param i 调整元素位置
     */
    private void heapfiy(int[] a, int n, int i){
        //自上往下
        while (true){
            int maxPos = i;
            if (i*2+1 < n && a[i] < a[2*i+1])
                maxPos = 2*i +1;
            if (i*2+2 < n && a[maxPos] < a[2*i+2])
                maxPos = i*2 + 2;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;//更新新位置，待继续比较
        }
    }

    /**
     * 建堆
     * @param a
     * @param n
     */
    public void buildHeap(int[] a, int n){
        for (int i = n/2; i >= 0; i--){
            heapfiy(a, n, i);
        }
    }

    /**
     *排序 供外入数组 O(nlogn)
     * @param a
     * @param n
     */
    public void sort(int[] a, int n){
        buildHeap(a, n);
        int k = n;
        while (k > 0){
            --k;
            swap(a,0, k);
            heapfiy(a, k, 0);
        }
    }

    /**
     * 内部属性排序
     */
    public void sort(){
        int k = n;
        while (k > 0){
            --k;
            swap(a,0, k);
            heapfiy(a, k, 0);
        }
    }

    /**
     * 打印堆
     */
    public void printHeap(){
        for (int i= 0; i < count; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
      /*  int[] nums = {0,1, -2, 29, -33, 90, 100, 45, 25};
        HeapZero heap = new HeapZero(nums.length);
        heap.sort(nums, nums.length);

        for (int num: nums){
            System.out.print(num + " ");
        }
        System.out.println();*/
        int[] a = {0,1, -2, 29, -33, 90, 100, 45, 25};
        HeapZero heapZero = new HeapZero(a);
        System.out.println("******构建堆************");
        heapZero.printHeap();
        System.out.println("******排序**************");
        heapZero.sort();
        heapZero.printHeap();
        System.out.println("******获取堆顶元素********");
        int top = heapZero.removeMax();
        System.out.println(top);
        heapZero.printHeap();
    }
}
