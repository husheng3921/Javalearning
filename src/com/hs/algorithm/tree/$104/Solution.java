package com.hs.algorithm.tree.$104;

import com.hs.algorithm.tree.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * LC104 二叉树的最大深度
 * @author hushe
 * @date 2020/5/5/0005 10:09
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归 时间复杂度O(n) 空间复杂度 O(n) -O(logn) dfs
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else{
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public int maxDepath(TreeNode root){
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null){
            queue.add(new Pair<>(root,1));
        }
        int depth = 0;
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> cur = queue.poll();
            root = cur.getKey();
            int cur_depth = cur.getValue();
            if (root != null){
                depth = Math.max(depth, cur_depth);
                queue.add(new Pair<>(root.left, cur_depth + 1));
                queue.add(new Pair<>(root.right, cur_depth + 1));
            }
        }
        return depth;
    }

    /**
     *  层次遍历求解
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return 0;
        }
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i  = 0; i < levelSize; i++){
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            depth ++;
        }
        return depth - 1;
    }
}
