package com.hs.algorithm.ali;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by husheng02.
 * 养鸡场问题
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 19:41
 */
public class Solution1 {
    public int getSum(int[] nums, int n, int m, int k){
        int sum = 0;
        int base = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int e : nums){
            queue.add(e);
            sum += e;
        }
        for(int i =0; i< m; i++){
            base += k;
            int temp = queue.poll() + base;
            System.out.println(temp);
            int sell = (temp + 1)/2;
            queue.add(temp - sell-base);
            sum -= sell;
        }
        return sum + n*m*k;
    }

    public static void main(String[] args) {
        int[] nums= {100, 200, 400};
        int n = 3, m = 3, k = 100;
        Solution1 s = new Solution1();
        System.out.println(s.getSum(nums, n, m , k));
    }
}
