package com.hs.algorithm.tree.$297;

import com.hs.algorithm.tree.TreeNode;

import java.util.LinkedList;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/22 10:16
 */
public class SolutionII {
    String SEP = ",";
    String NULL = "#";

    String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append(NULL).append(SEP);
            return;
        }
        /**
         * 前端遍历位置
         */
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    TreeNode deserialize(String data){
        //将字符串转换成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)){
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /**
     * 辅助函数，通过nodes列表构造二叉树
     * @param nodes
     * @return
     */
    private TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes.isEmpty()){
            return null;
        }
        /**前序遍历位置*****/
        //列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /************/
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
