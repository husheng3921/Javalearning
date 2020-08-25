package com.hs.algorithm.tree.$124;

import com.hs.algorithm.tree.TreeNode;

/**
 * Created by husheng02.
 * 二叉树中的最大路径和
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/10 22:06
 */
public class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){

        return max;
    }
    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //左右子树的贡献
        int left = dfs(root.right);
        int right = dfs(root.left);
        //当前节点的路径和：本身，本身加右子树和，本身加左子树和，本身加左右子树和
        int p = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(p, max);
        //计算节点与左右子树路径和
        int p2 = Math.max(p, root.val + left + right);
        max = Math.max(max, p2);
        return p;
    }
}
