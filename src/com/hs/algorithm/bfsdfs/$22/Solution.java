package com.hs.algorithm.bfsdfs.$22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/20 21:15
 */
public class Solution {
    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        if (n == 0){
            return res;
        }
        dfs("",res, n, n);
        return res;
    }

    /**
     *
     * @param s
     * @param res
     * @param left 剩余个数
     * @param right
     */
    private void dfs(String s, List<String> res, int left, int right) {
        if(left == 0 || right == 0){
            res.add(s);
        }
        if(left > 0){
            dfs(s+"(",res,left -1,right);
        }
        if(right > 0 && right > left){
            dfs(s+")",res,left,right-1);
        }
    }
}
