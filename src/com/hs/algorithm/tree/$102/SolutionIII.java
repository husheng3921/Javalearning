package com.hs.algorithm.tree.$102;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by husheng02.
 * 剑指offer 32-III
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 14:28
 */
public class SolutionIII {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++){
                TreeNode cur = queue.poll();
                if (level % 2==0){
                    temp.addLast(cur.val);
                }else {
                    temp.addFirst(cur.val);
                }
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }
            }
            list.add(temp);
            level++;
        }
        return list;
    }
}
