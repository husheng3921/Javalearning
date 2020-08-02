package com.hs.algorithm.tree.$429;

import com.hs.algorithm.tree.$589.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 *  LC429 N叉树层序遍历
 * @author hushe
 * @date 2020/5/4/0004 19:06
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        help(root,0,levels);
        return levels;
    }
    private void help(Node root, int level, List<List<Integer>> levels){
        if (levels.size() == level) levels.add(new ArrayList<>());

        levels.get(level).add(root.val);
        for (Node node : root.children){
            help(node, level + 1, levels);
        }
    }

    /**
     * 基于队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            levels.add(new ArrayList<>());
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++){
                Node cur = queue.remove();
                levels.get(level).add(cur.val);
                for (Node node : cur.children){
                    queue.add(node);
                }
            }
            level++;
        }
        return levels;
    }


}
