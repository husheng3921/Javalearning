package com.hs.algorithm.traceback.$113;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by husheng02.
 * 113 指定和输出路径
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/17 15:44
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res){
        //终止条件
        if (root == null){
            return;
        }
        if(root.val == sum && root.left == null && root.right == null){
            path.addLast(root.val);
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        //做选择
        path.addLast(root.val);
        dfs(root.left, sum - root.val, path, res);
        dfs(root.right, sum - root.val, path, res);
        path.removeLast();
    }
}
