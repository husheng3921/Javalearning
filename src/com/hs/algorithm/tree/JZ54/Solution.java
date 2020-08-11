package com.hs.algorithm.tree.JZ54;

import com.hs.algorithm.tree.TreeNode;

/**
 * Created by husheng02.
 * 第k大，注意中序遍历，排序从小到大，大到小
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 16:06
 */
public class Solution {
    int res, k;
    public int kthLargest(TreeNode root, int k){
        this.k = k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs(root.left);
    }
}
