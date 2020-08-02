package com.hs.algorithm.deque.$239;

import java.util.*;

/**
 * LC239
 * 滑动窗口中的最大值
 */
public class Solution {

    /**
     * O(k*n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        for(int i = 0; i < nums.length-k+1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j<k; j++) {
                if(nums[i+j] > max) {
                    max = nums[i + j];
                }
            }
            res[i] = max;
        }
       return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int[] q = new int [100005];
        int head = 0, tail = 0;
        for(int i = 0; i < nums.length; i++) {
            //nums[i]入队，将违反单调队列，从队列q中剔除
            while (head < tail && nums[q[tail - 1]]<nums[i]){
                tail--;
            }
            q[tail++] = i;//i入队
            //判断队列头部是否超出了窗口范围
            if(i - k == q[head]){
                head ++;
            }
            //输出区间内最大值
            if(i + 1 >= k){
                //System.out.println(nums[q[head]]);;
                list.add(nums[q[head]]);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * 单调队列 O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[]nums, int k) {
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int index = 0;
        for(int i = 0; i< n;i++){
            //如果i>k,窗口要向右移动，如果队头(最大)元素时窗口里的第一个元素则出队
            if(i>=k){
                if(max.peekFirst() == nums[i-k]){
                    max.removeFirst();
                }
            }
            //队列不为空，如果当前元素大于队列里面的元素，则从队尾移除掉，循环判断，保持队列里的元素单调性递减
            while (!max.isEmpty() && nums[i] > max.peekLast()) {
                max.removeLast();
            }
            max.addLast(nums[i]);//从队尾加入该元素
            if(i+1>=k){
                res[index++]=max.peekFirst();
            }
        }
        return res;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        //建立最大堆
        Queue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = nums.length;
        int[] res = new int[n-k+1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            //移除第一个元素,队顶元素出队,窗口超过设定值
            if(max.size() >= k){
                max.remove(nums[i-k]);
            }
            max.offer(nums[i]);//入队
            //更新result
            if(i >= k -1) {
                res[index++] = max.peek();
            }
        }
        return res;
    }


}
