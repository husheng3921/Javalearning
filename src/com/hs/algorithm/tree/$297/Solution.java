package com.hs.algorithm.tree.$297;

import com.hs.algorithm.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * LC297困难 二叉树的序列化反序列化
 * @author hushe
 * @date 2020/5/5/0005 11:36
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * DFS 前序遍历
     * @param root
     * @param str
     * @return
     */
    public String reserialize(TreeNode root, String str){
        if (root == null){
            str +="null,";
        }else{
            str += root.val + ",";
            str = reserialize(root.left, str);
            str = reserialize(root.right, str);
        }
        return str;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reserialize(root,"");
    }

    public TreeNode redeserialize(List<String> list){
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = redeserialize(list);
        node.right = redeserialize(list);

        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
       return redeserialize(dataList);
    }
}
