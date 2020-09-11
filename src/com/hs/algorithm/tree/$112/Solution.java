package com.hs.algorithm.tree.$112;

import com.hs.algorithm.tree.TreeNode;

/**
 * Created by husheng02.
 * simple  路径总和
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/04 21:43
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum -root.val) || hasPathSum(root.right, sum - root.val);
    }

}
