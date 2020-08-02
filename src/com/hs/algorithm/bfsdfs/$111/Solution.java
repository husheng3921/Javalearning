package com.hs.algorithm.bfsdfs.$111;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * LC111  二叉树的最小深度 简单
 * @author hushe
 * @date 2020/4/23/0023 15:49
 * @email husheng3921@163.com
 */
public class Solution {
    public static void main(String[] args) {

    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //root本身就是一层，初始化1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /*将队列中的所有结点向四周扩散*/
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点*/
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                /* 将cur加入相邻结点*/
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }

            }
            /*增加步数*/
            depth++;

        }
        return  depth;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null)
            return 0;

        if (root.right == null && root.left == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth1(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth,minDepth1(root.right));
        }
        return minDepth + 1;
    }
}
