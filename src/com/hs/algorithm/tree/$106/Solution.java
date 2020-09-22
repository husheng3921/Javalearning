package com.hs.algorithm.tree.$106;

import com.hs.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by husheng02.
 * 106从中序与后序遍历序列构造二叉树
 * https://mp.weixin.qq.com/s/OlpaDhPDTJlQ5MJ8tsARlA
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/22 9:51
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(inorder,0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if(inStart > inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = map.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);

        root.left = build(inorder, inStart, index -1, postorder, postStart, postStart+leftSize-1,map);
        root.right = build(inorder, index+1, inEnd, postorder, postStart+leftSize, postEnd-1, map);
        return root;
    }
}
