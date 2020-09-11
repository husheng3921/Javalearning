package com.hs.algorithm.traceback.$39;

import java.util.*;

/**
 * TODO
 * 组合总和I，无限次取
 * @author hushe
 * @date 2020/7/18/0018 16:01
 * @email husheng3921@163.com
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        int length = candidates.length;
        //排序提前终止
        Arrays.sort(candidates);
        dfs(candidates, target, 0,new Stack<>(), res);
        return res;
    }

    /**
     *
     * @param candiates  数组输入
     * @param len 输入数组的长度，冗余变量
     * @param residue 剩余数值
     * @param begin 本轮搜索的起点下标
     * @param path 从根节点到任意结点的路径
     * @param res 结果集变量
     */
    private void dfs(int[] candiates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res){
        if (residue == 0){
            //由于path全局只有一份，到叶子节点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i< len; i++){
            //数组有序下剪枝
            if (residue - candiates[i] < 0){
                break;
            }
            path.addLast(candiates[i]);
            dfs(candiates, len,residue - candiates[i], i, path, res);
            path.removeLast();
        }
    }
    private void dfs(int[] candiates, int target, int index, Stack<Integer> pre,List<List<Integer>> res){
        if (target == 0){
            //结果符合要求
            res.add(new ArrayList<>(pre));
        }
        //遍历，index为本分支
        for (int i = index; i < candiates.length;i++){
            if (candiates[i] <= target){
                pre.push(candiates[i]);
                dfs(candiates, target - candiates[i], i, pre, res);
                //回溯
                pre.pop();
            }else{
                break;//剪枝
            }
        }
    }

    /**
     * 数组元素重复，
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);//必须排序
        dfs1(candidates, target, 0, new Stack<>(), res);
        return res;
    }

    private void dfs1(int[] candiates, int target, int index, Stack<Integer> pre,List<List<Integer>> res ){
        if (target == 0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = index; i < candiates.length; i++){
            //排序后相同元素会相邻
            //小剪枝
            if (i > index && candiates[i] == candiates[i-1]){
                continue;
            }
            if (candiates[i] <= target ){
                pre.push(candiates[i]);
                dfs1(candiates,target - candiates[i], i+1, pre, res);
                pre.pop();
            }else{
                break;//排序后，当前元素满足，后面无需再搜索
            }
        }
    }
}
