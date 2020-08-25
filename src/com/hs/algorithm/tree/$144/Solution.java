package com.hs.algorithm.tree.$144;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 * LC144 二叉树前序遍历 中等
 * @author hushe
 * @date 2020/5/4/0004 15:55
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }
    private void help(TreeNode root, List<Integer> res){
        if (root != null){
            res.add(root.val);
            if (root.left != null){
                help(root.left, res);
            }
            if (root.right != null){
                help(root.right, res);
            }
        }
    }

    /**
     * 基于栈，入栈时需要右节点先入，因为涉及先进后出
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();//取栈顶元素
            res.add(cur.val);//取结果
            //栈先进后出，左节点出栈在前，则右节点先进栈
            if (cur.right != null){
                stack.push(cur.right);//这里技巧，不是插入左边
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * 不能用队列
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();//取栈顶元素
            res.add(cur.val);//取结果
            //栈先进后出，左节点出栈在前，则右节点先进栈
            if (cur.right != null){
                stack.push(cur.right);//这里技巧，不是插入左边
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
        return res;
    }
}
