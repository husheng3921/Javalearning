package com.hs.algorithm.tree.$107;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * LC107 二叉树的层次遍历II简单
 * @author hushe
 * @date 2020/5/4/0004 19:20
 * @email husheng3921@163.com
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int levle_lengeth = queue.size();
            for(int i = 0; i <levle_lengeth; i++){
                TreeNode cur = queue.remove();
                tmp.add(cur.val);
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            levels.add(0,tmp);//前插法
        }
        return levels;
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> levels = new LinkedList<>();
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
}
