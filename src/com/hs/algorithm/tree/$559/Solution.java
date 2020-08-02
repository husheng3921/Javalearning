package com.hs.algorithm.tree.$559;

import com.hs.algorithm.tree.$589.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * N叉树的最大深度
 * @author hushe
 * @date 2020/5/5/0005 11:15
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归遍历
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max_depth = 0;
        for (Node node : root.children){
            max_depth = Math.max(max_depth, maxDepth(node));
        }
        return max_depth + 1;
    }

    public int maxDepth1(Node root){
        Queue<Node> queue = new LinkedList<>();
        if (root == null){
            return 0;
        }
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int depthSize = queue.size();
            for (int i = 0; i < depthSize; i++){
                Node cur = queue.poll();
                for(Node node: cur.children){
                    queue.add(node);
                }
            }
            depth++;
        }
        return depth-1;
    }
}
