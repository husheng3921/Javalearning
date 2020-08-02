package com.hs.algorithm.bfsdfs.$433;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * TODO
 * LC433 最小基因变化 中等
 * @author hushe
 * @date 2020/5/5/0005 16:43
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 广度优先搜索
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        LinkedList<String> queue = new LinkedList<>();
        //用于记录搜索过的
        boolean[] flags = new boolean[bank.length];
        queue.add(start);
        int result = 0;
        while (!queue.isEmpty()){
            result ++;
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++){
                String cur = queue.poll();
                for (int j = 0; j < bank.length; j++){
                    //bank[j]字符串没有被搜索过，并且和当前字符串只相差一个字符
                    if (!flags[j] && verification(cur, bank[j])){
                        //如果当前库里面的元素等于目标值，则直接返回
                        if (bank[j].equals(end)){
                            return result;
                        }
                        //否则添加到队列中，作为突变的结果
                        queue.add(bank[j]);
                        flags[j] = true;
                    }
                }
            }
        }
        return -1;
    }
    private boolean verification(String str1, String str2){
        int count =0;
        for (int i =0; i <str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if (count > 1){
                return false;
            }
        }
        return true;
    }

    int minStepCount = Integer.MAX_VALUE;
    /**
     * 回溯
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation1(String start, String end, String[] bank) {
        dfs(new HashSet<>(),0,start,end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1:minStepCount;
    }
    private void dfs(HashSet<String> step, int stepCount,
                     String current, String end, String[] bank){
        if (stepCount >= minStepCount) return;
        if (current.equals(end)){
            minStepCount = Math.min(stepCount, minStepCount);
        }
        for (String str : bank){
            if (verification(current, str)){
                if (!step.contains(str)){
                    step.add(str);
                    dfs(step, stepCount + 1, str, end,bank);
                    step.remove(str);
                }
            }

        }
    }
}
