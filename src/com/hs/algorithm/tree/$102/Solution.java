package com.hs.algorithm.tree.$102;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * LC102 二叉树层序遍历 中等
 * @author hushe
 * @date 2020/5/4/0004 18:50
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归遍历 O(N) O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        help(root,0,levels);
        return levels;
    }
    private void help(TreeNode root, int level, List<List<Integer>> levels){
        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(root.val);

        if (root.left != null){
            help(root.left, level + 1, levels);
        }
        if (root.right != null){
            help(root.right, level + 1, levels);
        }
    }

    /**
     * 层序遍历用队列 O(N) O(N) 先进先出
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root){
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            levels.add(new ArrayList<Integer>());

            int level_length = queue.size();
            for (int i = 0; i < level_length; i++){
                TreeNode cur = queue.remove();

                levels.get(level).add(cur.val);

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            level ++;
        }
        return levels;
    }


}
