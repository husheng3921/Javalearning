package com.hs.algorithm.tree.$236;

import com.hs.algorithm.tree.TreeNode;

/**
 * TODO
 * LC235 二叉树的最近公共祖先 中等
 * @author hushe
 * @date 2020/5/4/0004 19:53
 * @email husheng3921@163.com
 */
public class Solution {
    TreeNode res;
    /**
     * O（N） O（N)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        //递归结束条件，如果当前结点为空，或者已经找到结果则返返回false
        if (root == null || this.res != null){
            return false;
        }
        //递归查找左右子树是否包含目标结点
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);

        //判断当前结点是否为目标结点
        boolean mid = (root == p||root ==q);
        if ((left && right)||(mid &&(left || right))){
            res = root;
        }
        //返回当前结点或其子树是否包含目标结点
        return left || right || mid;
    }

    /**
     * O(N) O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null || root == p || q == root){
           return root;
       }
       TreeNode left = lowestCommonAncestor1(root.left, p, q);
       TreeNode right = lowestCommonAncestor1(root.right, p, q);
       if (left == null){
           return right;
       }else if(right == null){
           return left;
       }else{
           return root;
       }
    }
}
