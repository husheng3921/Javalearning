package com.hs.algorithm.traceback.combine;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * LC77 组合
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485007&idx=1&sn=ceb42ba2f341af34953d158358c61f7c&chksm=9bd7f847aca071517fe0889d2679ead78b40caf6978ebc1d3d8355d6693acc7ec3aca60823f0&scene=21#wechat_redirect
 * @author hushe
 * @date 2020/4/24/0024 13:05
 * @email husheng3921@163.com
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine2(int n, int k) {
        if (k <=0 || n <= 0) return res;
        List<Integer> track = new ArrayList<>();
        backtrack2(n,k,1,track);
        return res;
    }
    void backtrack2(int n, int k, int start, List<Integer> track) {
        // 到达树的底部
        if (k == track.size()) {
            res.add(new ArrayList(track));
            return;
        }
        // 注意i从start开始递增
        for (int i = start; i < n+1; i++) {
            //做选择
            track.add(i);
            backtrack2(n,k,i+1,track);
            //撤销选择
            track.remove(track.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        if (k <=0 || n <= 0) return res;
        List<Integer> track = new LinkedList<>();
        backtrack(n,k,1, (LinkedList<Integer>) track);
        return res;
    }
    void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        // 到达树的底部
        if (k == track.size()) {
            res.add(new LinkedList(track));
            return;
        }
        // 注意i从start开始递增
        for (int i = start; i < n+1; i++) {//[1~n]
            //做选择
            track.add(i);
            backtrack(n,k,i+1,track);
            //撤销选择
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4,2).size());
    }
}
