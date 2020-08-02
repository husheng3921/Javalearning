package com.hs.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * LC22括号生成
 * @author hushe
 * @date 2020/4/26/0026 22:24
 * @email husheng3921@163.com
 */
public class LC22 {
    public List<String> generataParenthesis(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     * 回溯算法 空间复杂度O(n)
     * @param ans
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }
        if (open < max){
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open){
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    /**
     * 从0开始构造树
     * @param cur 当前递归得到的结果
     * @param left 左括号用了几个
     * @param right 右括号用了几个
     * @param n 括号对数
     * @param res 结果集
     */
    public void dfs1(String cur, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(cur);
            return;
        }
        //剪枝 如果右括号用的个数多，不符合逻辑，因为括号是后加，要匹配必须是先
        //左括号再右括号，所以剪枝
        if (left < right){
            return;
        }

        if (left < n) {
            dfs1(cur + "(", left + 1, right, n, res);
        }

        if (right < n) {
            dfs1(cur +")", left, right + 1, n, res);
        }
    }
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0){
            return res;
        }
        dfs1("",0,0, n,res);
        return res;
    }

    /**
     *  深度优先搜索，
     * @param cur 当前字符串
     * @param left 左括号可用个数
     * @param right 右括号可用个数
     * @param res 结果集
     */
    public void dfs2(String cur, int left, int right, List<String> res){
        if (left == 0 && right == 0){
            res.add(cur);
            return;
        }

        //剪枝 当左括号可用个数大于右边，说明右括号先用了，不符合逻辑
        //因为构造是后加"("或")",所以必须是"("先用，那么左括号的可用个数必须小于右边否则停止
        if (left > right){
            return;
        }
        if (left > 0) {
            dfs2(cur + "(", left - 1, right, res);
        }
        if (right > 0) {
            dfs2(cur + ")", left, right - 1, res);
        }
    }
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs2("",n, n, res);
        return res;
    }
    public static void main(String[] args) {
        LC22 lc22 = new LC22();
        System.out.println(lc22.generataParenthesis(3));
        System.out.println(lc22.generateParenthesis1(3));
    }
}
