package com.hs.algorithm.heap;

import java.util.PriorityQueue;

/**
 * TODO
 * 利用堆求中位数，大顶堆存放比中位数小的，小顶堆存放比中位数大的
 * @author hushe
 * @date 2020/4/30/0030 19:29
 * @email husheng3921@163.com
 */
public class MidNumCount {
    /**
     *
     */
    /** 大顶堆，用来存储前半部分的数据，如果完整为100，那此存储的为0-50 */
    private PriorityQueue<Integer> fistBigHeap = new PriorityQueue<>(51,((o1, o2) -> {
        return o2 - o1;
    }));
    private PriorityQueue<Integer> afterLittleHeap = new PriorityQueue<>(51);

    /**元素的个数**/
    private int count;

    public void putNum(int num){
        count++;
        //如果堆为空则插入大顶堆
        if (fistBigHeap.isEmpty() && afterLittleHeap.isEmpty()){
            fistBigHeap.offer(num);
            return;
        }
        //如果当前元素比堆顶元素大，则插入小顶堆
        if (fistBigHeap.peek() < num){
            afterLittleHeap.offer(num);
        }else{//如果当前元素比堆顶元素小，则插入大顶堆
            fistBigHeap.offer(num);
        }
        int countValue = count/2;
        //如果大顶堆中的数据超过了中位数，则需要移动
        //因为大顶堆中存储的数据为n/2+1个，当n为奇数，所以每次取数，仅返回大顶堆中的数据即可
        if (fistBigHeap.size() > countValue){
            move(fistBigHeap, afterLittleHeap, fistBigHeap.size() - countValue);
            return;
        }
        //如果小顶堆中的数据超过了中位数，有需要移动
        if (afterLittleHeap.size() > countValue){
            move(afterLittleHeap, fistBigHeap, afterLittleHeap.size() - countValue);
        }
    }

    public int getMidValue(){
        return fistBigHeap.peek();
    }

    /**
     * 从一个堆中向另一个堆中移动元素
     * @param src
     * @param des
     * @param runNum
     */
    private void move(PriorityQueue<Integer> src, PriorityQueue<Integer> des, int runNum){
        for (int i = 0; i< runNum;i++){
            des.offer(src.poll());
        }
    }
}
