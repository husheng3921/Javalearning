package com.hs.algorithm.traceback.permute;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * LC 46 全排列 中等
 * @author hushe
 * @date 2020/4/24/0024 13:04
 * @email husheng3921@163.com
 */
public class $46 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }
    void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
        }
        // 选择列表
        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择
            if (track.contains(nums[i])) {
                continue;//后面不再运行，继续下一次循环；break，跳出当前循环区
            }
            track.add(nums[i]);
            //递归
            backtrack(nums,track);
            //撤销选择
            track.removeLast();
        }
    }
    public List<List<Integer>> permute1(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }
    public void bt(int[] nums,boolean[] visited, LinkedList<Integer> trace){
        //结束条件
        if (trace.size() == nums.length){
            res.add(new LinkedList<>(trace));
            //return;
        }
        //选择列表
        for (int i = 0; i < nums.length; i++){
            //如果访问过不再访问
            if (visited[i]) continue;
            //接下来，当前结点与前一个结点一样，并且他的前一个结点遍历过

            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            bt(nums,visited,trace);
            //撤销选择
            trace.removeLast();
            visited[i] = false;
        }

    }

    /**
     * 无重复元素排列
     * @param data
     * @param n
     * @param k
     */
    public void printPerumations(int[] data, int n, int k){
        if (k == 1){
            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; i++){
          /*  int tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;*/
            swap(data,i,k-1);
            printPerumations(data,n, k - 1);
            /*tmp = data[i];
            data[i] = data[k-1];
            data[k-1] = tmp;*/
            swap(data,i, k-1);
        }
    }
    public void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static void main(String[] args) {
        int[] a ={1, 2, 3, 4};
        $46 solution = new $46();
        solution.printPerumations(a, 4, 4);
        System.out.println("**********************");
        int[] a1 ={1, 2, 3, 4};
        List<List<Integer>> res = solution.permute1(a1);
        for (List item:res){
            for (Object num : item){
                System.out.print(num +" ");
            }
            System.out.println();
        }
    }
}
