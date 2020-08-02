package com.hs.algorithm.tree.$145;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 * LC145 二叉树的后续遍历 困难
 * @author hushe
 * @date 2020/5/4/0004 16:19
 * @email husheng3921@163.com
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        help(root, res);
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        if (root != null){
            if (root.left != null){
                help(root.left, res);
            }
            if (root.right != null){
                help(root.right, res);
            }
            res.add(root.val);
        }
    }

    /**
     * 基于栈，输出的结果是后续遍历的逆序，故才有前插法，翻转
     * DFS 从下往上搜索，而实际是上往下，所以逆序输出
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null){
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);//前插法，即最后出的元素在前
            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
        }
        return res;
    }
}
