package com.hs.algorithm.tree.$98;

import com.hs.algorithm.tree.TreeNode;

import java.util.Stack;

/**
 * TODO
 * LC98 验证二叉搜素树 中等
 * @author hushe
 * @date 2020/5/5/0005 9:22
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归，确保左子节点都要小于右子树的所有结点，辅助结点
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
       return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min){
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left,min,root) && isValidBST(root.right, root,max);
    }

    /**
     * 中序遍历得到升序数列 每次维护一个最大值，如果后面的值小于这个最大值就不是二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double inOrder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root !=null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //如果遍历中得到的结点值小于等于前一个inorder，说明不是二叉搜索树
            if (root.val <= inOrder) return false;
            inOrder = root.val;
            root = root.right;//
        }
        return true;
    }
}
