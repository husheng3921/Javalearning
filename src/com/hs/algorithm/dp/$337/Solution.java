package com.hs.algorithm.dp.$337;

import com.hs.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 打家劫舍III，
 * @author hushe
 * @date 2020年9月7日, 0007 17:26
 * @email husheng3921@163.com
 */
public class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root){
        if (root == null){
            return 0;
        }
        //备忘录去重复
        if(map.containsKey(root)){
            return map.get(root);
        }
        //分抢这节点，则需要抢下下个结点
        int doIt = root.val + (root.left == null ? 0:rob(root.left.left)+rob(root.left.right))+
                (root.right == null ? 0: rob(root.right.right)+rob(root.right.left));
        int doNotIt = rob(root.left) + rob(root.right);
        int res = Math.max(doIt, doNotIt);
        map.put(root, res);
        return res;
    }
}
