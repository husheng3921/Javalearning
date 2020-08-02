package com.hs.algorithm.traceback.permute;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * LC47 全排列II，中等，含重复元素
 * @author hushe
 * @date 2020/5/5/0005 13:02
 * @email husheng3921@163.com
 */
public class $47 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        Arrays.sort(nums);
        bt(nums,new boolean[nums.length], trace);
        return res;
    }
    private void bt(int[] nums,boolean[] visited, LinkedList<Integer> trace){
        //结束条件
        if (trace.size() == nums.length){
            res.add(new LinkedList<>(trace));
        }
        //选择列表
        for (int i = 0; i < nums.length; i++){
            //访问过，继续下一次
            if (visited[i]) continue;
            //当前结点与前结点重复，且前一个结点被访问过
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) continue;
            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            bt(nums,visited,trace);
            //撤销
            trace.removeLast();
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        $47 solution = new $47();
        int[] nums={1,2,2,4};
        List<List<Integer>> res = solution.permuteUnique(nums);
        for (List item:res){
            for (Object num : item){
                System.out.print(num +" ");
            }
            System.out.println();
        }
    }
}
