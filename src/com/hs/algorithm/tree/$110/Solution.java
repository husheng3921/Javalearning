package com.hs.algorithm.tree.$110;

import com.hs.algorithm.tree.TreeNode;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 16:25
 */
public class Solution {
    int depth = 0;
    public boolean isBalanced(TreeNode root){
        return recur(root) != -1;
    }
    //后序遍历
    int recur(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = recur(root.left);
        if(left == -1){
            return -1;
        }
        int right = recur(root.right);
        if(right == -1){
            return -1;
        }
        //若深度差小于1，则取最大深度+1；不小于则返回-1
        return Math.abs(left - right) < 2? Math.max(left, right) + 1 : -1;
    }
}
