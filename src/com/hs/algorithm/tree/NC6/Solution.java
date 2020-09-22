package com.hs.algorithm.tree.NC6;

import com.hs.algorithm.tree.TreeNode;

/**
 * Created by husheng02.
 * 给定一个二叉树，计算节点之和最大的路径的节点之和是多少
 * {-2,1} 1
 * {-2，-3}-2
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/11 20:12
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        if (root == null){
            return 0;
        }

        return max;
    }
    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right),0);
        max = Math.max(max, root.val + left+right);
        return Math.max(root.val + left, root.val + right);
    }
}
