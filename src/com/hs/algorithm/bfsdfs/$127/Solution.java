package com.hs.algorithm.bfsdfs.$127;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * LC127 单词接龙 中等
 * @author hushe
 * @date 2020/5/5/0005 17:24
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * BFS
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<String> resString = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        if (!wordList.contains(endWord)) return 0;//不在字典中
        int result = 1;
        queue.add(beginWord);
        //补充
        resString.add(beginWord+"->");
        boolean[] visited = new boolean[wordList.size()];
        while (!queue.isEmpty()){
            result++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++){
                String cur = queue.poll();
                for (int j = 0; j < wordList.size(); j++){
                    if (!visited[j] && verifOne(cur, wordList.get(j))){
                        if (endWord.equals(wordList.get(j))){
                            return result;
                        }
                        queue.add(wordList.get(j));
                        visited[j] = true;
                    }
                }
            }
        }
        return 0;
    }


    private boolean verifOne(String str1, String str2){
        int count = 0;
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                count++;
            }
            if (count >1){
                return false;
            }
        }
        return true;
    }
}
