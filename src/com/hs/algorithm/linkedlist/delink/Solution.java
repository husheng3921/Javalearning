package com.hs.algorithm.linkedlist.delink;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 * 二叉搜素树转换成双向链表，left->lnext,right->rnext
 * @author hushe
 * @date 2020年9月7日, 0007 9:09
 * @email husheng3921@163.com
 */
public class Solution {
    public TreeNode convertToDlink(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        inOrder(head, queue);
        head = queue.poll();
        head.left = null;
        TreeNode cur = null, pre = head;
        while (!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    /**
     * 中序遍历
     * @param root
     * @param queue
     */
    private void inOrder(TreeNode root, Queue<TreeNode> queue){
        if(root == null){
            return;
        }
        inOrder(root.left,queue);
        queue.add(root);
        inOrder(root.right,queue);
    }
}
