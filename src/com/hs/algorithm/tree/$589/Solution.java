package com.hs.algorithm.tree.$589;

import java.util.*;

/**
 * TODO
 * LC589 N叉树的前序遍历 简单
 * @author hushe
 * @date 2020/5/4/0004 16:42
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归遍历
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }
    private void help(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            for (Node node : root.children) {
                help(node, res);
            }
        }
    }

    /**
     * 基于栈，把最右边的先入栈
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root){
        List<Integer> res = new LinkedList<>();
        Stack<Node>  stack = new Stack<>();
        if (root == null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            res.add(cur.val);
            Collections.reverse(cur.children);//重要翻转list
            for (Node node : cur.children){
                stack.push(node);
            }
        }
        return res;
    }
}
