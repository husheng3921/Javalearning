package com.hs.algorithm.heap;

import java.util.PriorityQueue;

/**
 * TODO
 * TopK计数
 * @author hushe
 * @date 2020/4/30/0030 19:19
 * @email husheng3921@163.com
 */
public class TopKCount {
    /**
     * 求数据中前K大数据
     * @param data
     * @param k
     * @return
     */
    public int[] topK(int[] data, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < data.length; i++){
            if (queue.size() < k){
                queue.offer(data[i]);
            }else {
                int value = queue.peek();//获取队头元素，小顶堆
                //如果发现元素比堆顶元素大，则加入到小顶堆
                if (data[i] > value){
                    queue.poll();//出堆
                    queue.offer(data[i]);
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        //遍历堆
        while (!queue.isEmpty()){
            res[index++] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {12,6,-9,62,78,5,9};
        TopKCount tp = new TopKCount();
        int[] res = tp.topK(nums, 3);
        for (int num : res){
            System.out.print(num+" ");
        }
    }
}
