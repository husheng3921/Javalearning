package com.hs.algorithm.tree.$103;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/08 15:09
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode cur = queue.poll();

                if(depth % 2 == 1){
                    level.addLast(cur.val);
                }else{
                    level.addFirst(cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            depth++;
            res.add(level);
        }
        return res;
    }
}
