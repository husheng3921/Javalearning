package com.hs.algorithm.tree.$108;

import com.hs.algorithm.tree.TreeNode;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/08 15:15
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums){
        return helper(nums,0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,mid+1,right);
        root.right = helper(nums,left,mid - 1);
        return root;
    }
}
