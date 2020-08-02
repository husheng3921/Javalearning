package com.hs.algorithm.tree.$637;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * LC637 层次平均值
 * @author hushe
 * @date 2020/5/4/0004 19:49
 * @email husheng3921@163.com
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> alevels = new LinkedList<>();
        if(root == null) return alevels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int level_length = queue.size();
            double sum = 0.0, avglevel = 0.0;
            for(int i = 0; i < level_length; i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            avglevel = sum / level_length;
            alevels.add(avglevel);
        }
        return alevels;
    }
}
