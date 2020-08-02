package com.hs.algorithm.tree.$199;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 * LC 199 midle
 * @author hushe
 * @date 2020/6/24/0024 18:19
 * @email husheng3921@163.com
 */
public class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root){
        dfs(root, 0);
        return res;
    }
    //DFS 根节点->右节点->左节点
    private void dfs(TreeNode root, int depth){
        if (root == null){
            return ;
        }
        //先访问当前结点，再递归访问右节点，左节点
        if (depth == res.size()){
            res.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left, depth);

    }

    //BFS 广度优先搜索，层次遍历，记录每层最后一个元素
    public List<Integer> bfs(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (i== size-1){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
