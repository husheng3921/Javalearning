package com.hs.collection;

import java.util.*;

/**
 * TODO
 * Collections
 * @author hushe
 * @date 2020/4/29/0029 15:33
 * @email husheng3921@163.com
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-3);
        list.add(8);
        list.add(23);
        list.add(10);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        int res = Collections.binarySearch(list,23);
        System.out.println(res);
        //长度属性或函数
        int[] nums = {1,3,5,7,9};
        int numsLength = nums.length; //属性
        //长度函数
        String s = "123456";
        int sLength = s.length();


    }
}
