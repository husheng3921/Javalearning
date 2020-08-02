package com.hs.algorithm.tree.$515;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * LC515在每个树行中找最大值 中等
 * @author hushe
 * @date 2020/5/5/0005 16:29
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 层次遍历，BFS
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        //res.add(root.val);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int maxNode = Integer.MIN_VALUE;
            for (int i =0; i < levelSize; i++){
                TreeNode cur = queue.poll();
                maxNode = maxNode >= cur.val ? maxNode:cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(maxNode);
        }
        return res;
    }
}
