package com.hs.algorithm.tree.$235;

import com.hs.algorithm.tree.TreeNode;

/**
 * TODO
 * LC235 二叉搜索树的最近公共祖先 简单
 * @author hushe
 * @date 2020/5/4/0004 19:53
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * O（N） O（N)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;

        int pVal = p.val;

        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestor(root.right, p , q);
        }else if (pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return root;
        }
    }

    /**
     * O(N) O(1)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;

        int qVal = q.val;
        TreeNode cur = root;
        while (cur!=null){
            int parentVal = cur.val;
            if (pVal > parentVal && qVal > parentVal){
                cur = cur.right;
            }else if (pVal < parentVal && qVal < parentVal){
                cur = cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }
}
