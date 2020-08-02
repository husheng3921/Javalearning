package com.hs.algorithm.tree.$105;

import com.hs.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * TODO
 * LC105 从前序和中序遍历构造二叉树 中等
 * 前中后序遍历主要是针对：root结点的顺序
 * 前序： root,left,right
 * 中序:  left,root,right
 * 后序:  left,right,root
 * @author hushe
 * @date 2020/5/5/0005 16:30
 * @email husheng3921@163.com
 */
public class Solution {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     *  O(N) O(N)
     * @param preorder
     * @param inorder
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                                int inorder_left, int inorder_right){
        if (preorder_left > preorder_right){
            return null;
        }
        //前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_left]);

        //先把根节点建立起来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        //得到左子树中的节点数目
        int sizeLeftSubtree = inorder_root - inorder_left;
        //递归构造左子树，并连接根节点
        //前序遍历中[从左边界+1开始的size_left_subtree]个元素就对应了中序遍历中[从左节点开始到根节点-1]的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left+ sizeLeftSubtree, inorder_left, inorder_root -1);
        //递归构造右子树，连接根节点
        //先序遍历中[左边界+1+左子树节点数目到右界元素]对应中序遍历中[根节点+1到右边界]的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + 1 + sizeLeftSubtree, preorder_right,inorder_root + 1, inorder_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        //构造哈希映射
        for (int i = 0; i < n; i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder){
        if (preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);//根节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 0; i < preorder.length; i++){
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
