package com.hs.algorithm.traceback.subset;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * LC78
 * 子集问题
 * @author hushe
 * @date 2020/4/24/0024 13:03
 * @email husheng3921@163.com
 */
public class Solution {

    /**
     *
     * @param nums
     * @return
     */
    List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int item : nums) {
           List<List<Integer>> newSubsets = new ArrayList<>();
           for (List<Integer> curr : res) {
               newSubsets.add(new ArrayList<Integer>(curr){{add(item);}});
           }
            for (List<Integer> curr : newSubsets) {
                res.add(curr);
            }
        }
        return  res;

    }

    /**
     * 回溯
     */
    List<List<Integer>> res = new ArrayList<>();
    public void backtrack(int first, ArrayList<Integer> track, int[] nums) {

        res.add(new ArrayList(track));

        for (int i = first; i < nums.length; i++){
            //添加nums[i]到当前组合
            track.add(nums[i]);
            // 下个数来完成组合
            backtrack(i + 1, track, nums);
            // 回溯
            track.remove(track.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums){
        // 记录走过的路径
        List<Integer> track = new ArrayList<>();
        backtrack(0, (ArrayList<Integer>) track,nums);
        return res;
    }

    public List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> trd = new ArrayList<>();
        if (nums == null) return res;
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.subsets(nums).size());
    }

}
