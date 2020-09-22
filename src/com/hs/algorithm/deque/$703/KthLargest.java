package com.hs.algorithm.deque.$703;

import java.util.PriorityQueue;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/20 12:48
 */
public class KthLargest {
    private int K;
    private PriorityQueue<Integer> priorityQueue;
    public KthLargest(int k, int[] nums){
        this.K = k;
        this.priorityQueue = new PriorityQueue<>(k);
        for (int num:nums){
            priorityQueue.add(num);
        }
    }
    public int add(int val){
        if (priorityQueue.size() < K){
            priorityQueue.add(val);
        }else if(priorityQueue.peek() < val){
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        //保存返回
        return priorityQueue.peek();
    }
}
