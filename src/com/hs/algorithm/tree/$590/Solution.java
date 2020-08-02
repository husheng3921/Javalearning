package com.hs.algorithm.tree.$590;

import com.hs.algorithm.tree.$589.Node;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 * LC590 N叉树后序遍历 简单
 * @author hushe
 * @date 2020/5/4/0004 17:12
 * @email husheng3921@163.com
 */
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new LinkedList<>();
        help(root, res);
        return res;
    }
    private void help(Node root, List<Integer> res) {
        if (root != null){
            for (Node node : root.children){
                help(node, res);
            }
            res.add(root.val);
        }
    }

    /**
     * 基于栈，链式存储
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            res.addFirst(cur.val);
            for (Node node : cur.children){
                stack.push(node);
            }
        }
        return res;
    }
}
