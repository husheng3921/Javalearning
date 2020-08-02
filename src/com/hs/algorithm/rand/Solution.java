package com.hs.algorithm.rand;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * TODO
 * 洗牌算法
 * @author hushe
 * @date 2020/4/24/0024 12:21
 * @email husheng3921@163.com
 */
public class Solution {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Solution solution = new Solution();
        int[] arr = {1, 3, 5, 7, 9};
        /*for(int i = 0; i < 100; i++){
        int rand = (new Solution()).randInt(0,10);
        System.out.println(rand);
        }*/
        solution.shuffle(arr);
        for(int item : arr)
            System.out.print(item+" ");

    }

    /**
     * 得到 闭区间[min,max]内随机整数,nextInt(n),[0,n)
     * @param min
     * @param max
     * @return
     */
    int randInt(int min, int max) {
        Random random = new Random();
        //int ran=(int)(Math.random()*(max-min+1))+min
        //Random ran=new Random();int a=ran.nextInt(max-min+1)+min;
        return random.nextInt(max-min + 1) + min;
    }


    void shuffle(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int rand = randInt(i, n - 1);
            int temp = arr[i];
            arr[i] = arr[rand];
            arr[rand] = temp;
        }
    }

}
