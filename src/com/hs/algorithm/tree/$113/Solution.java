package com.hs.algorithm.tree.$113;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by husheng02.
 * 路径总和II
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/11 19:31
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        bt(root,sum,new Stack<>(),res);
        return res;
    }
    private void bt(TreeNode root, int sum, Stack<Integer> path, List<List<Integer>> res){
        if (root == null){
            return;
        }
        if(root.val == sum && root.right == null && root.left == null ){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.pop();
            return;
        }
        path.add(root.val);
        bt(root.left, sum - root.val, path, res);
        bt(root.right, sum - root.val, path, res);
        path.pop();
    }
    List<List<Integer>> res = new ArrayList<>();
    private void dfs(TreeNode root, int sum, LinkedList<Integer> temp){
        if(root == null){
            return;
        }
        //记录路径
        temp.addLast(root.val);
        //判断终止
        if(root.left == null && root.right == null && sum == root.val){
            res.add(temp);
        }
        dfs(root.left, sum - root.val, temp);
        dfs(root.right, sum - root.val, temp);
        temp.removeLast();//遍历完后，需要把当前节点剔除
    }
}
