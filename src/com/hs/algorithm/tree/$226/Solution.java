package com.hs.algorithm.tree.$226;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * 226 简单，翻转二叉树
 * @author hushe
 * @date 2020/5/5/0005 9:11
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 基于队列
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root){
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();//队头元素
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
        return root;
    }
}
