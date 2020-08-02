package com.hs.algorithm.tree.$111;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * LC111 二叉树的最小深度
 * @author hushe
 * @date 2020/5/5/0005 10:39
 * @email husheng3921@163.com
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.right == null && root.left == null){
            return 1;
        }
        int depth = Integer.MAX_VALUE;
        if (root.left!= null){
            depth = Math.min(depth,minDepth(root.left));
        }
        if (root.right != null){
            depth = Math.min(depth, minDepth(root.right));
        }
        return depth+1;
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root){
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
}
