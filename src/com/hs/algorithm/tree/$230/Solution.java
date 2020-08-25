package com.hs.algorithm.tree.$230;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by husheng02.
 * 230 二叉搜索树第k小的元素
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/14 15:51
 */
public class Solution {
    private List<Integer> res = new LinkedList<>();
    public int kthSmallest(TreeNode root, int k){
        dfs(root);
        return res.get(k - 1);
    }
    private void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

}
