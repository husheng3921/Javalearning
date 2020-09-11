package com.hs.algorithm.sort.$347;

import java.util.*;

/**
 * TODO
 *
 * @author hushe
 * @date 2020年9月7日, 0007 17:41
 * @email husheng3921@163.com
 */
public class Solution {
    class Pair{
        Integer key;
        Integer value;

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    List<Pair> list = new ArrayList<>();
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (int i = 0; i < k; i++){
            res.add(list.get(i).getKey());
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
