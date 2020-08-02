package com.hs.algorithm.tree.$94;

import com.hs.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 * LC94 二叉树的中序遍历 中等
 * @author hushe
 * @date 2020/5/4/0004 15:37
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 递归实现  时间复杂度O(n) T(n)=2*T(n/2) + 1;空间复杂度最坏O(n),平均情况O(logn)
     *  midOrder(left)
     *  print(root)
     *  midOrder(right)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        help(root, res);
        return res;
    }
    private void help(TreeNode root, List<Integer> res){
        if (root != null){
            if (root.left != null){
                help(root.left, res);
            }
            res.add(root.val);

            if (root.right != null){
                help(root.right, res);
            }
        }
    }

    /**
     * 基于栈 O(n) O(n)
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur != null){//依次沿着左边入栈
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();//到达叶子节点出栈
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
