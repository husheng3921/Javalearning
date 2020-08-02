package com.hs.algorithm.dp.$45;

import javax.sound.midi.Soundbank;

/**
 * TODO
 * 45 接雨水 hard
 * @author hushe
 * @date 2020/6/20/0020 11:23
 * @email husheng3921@163.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
        System.out.println(solution.trap1(height));
        System.out.println(solution.trap2(height));
    }

    //1.直观算法，依次找该柱子左右两边的高柱子，两边的矮柱子减高O(N^2) O(1)
    public int trap(int[] height){
        int ans = 0;
        int size = height.length;
        for(int i = 0; i < size; i++){
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j>=0;j--){
                maxLeft = Math.max(maxLeft,height[j]);
            }
            for (int j = i; j < size; j++){
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxRight, maxLeft) - height[i];
        }
        return ans;
    }

    /**
     *  找到数组中从下标i到最左端最高的条形块高度leftMax
     *  找到数组中从下标i到最右端高端的条形块高度rightMax
     *  扫描数组height并更新：
     *  min(max_left[i],max_right[i])-height[i] 到ans
     * @param height
     * @return
     */
    public int trap2(int[] height){
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        //初始化
        leftMax[0] = height[0];
        for (int i = 1; i<size;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        rightMax[size-1] = height[size-1];
        for (int i = size - 2; i>= 0;i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        for (int i = 1; i < size-1;i++){
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
    /**
     * 2. 双指针 O(n) O(1)
     * @param height
     * @return
     */
    public int trap1(int[] height){
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right){
            if (height[left] < height[right]){
                //height[left] >= leftMax ? (leftMax = height[left]): ans+=(leftMax -height[left]);
                if (height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    ans += leftMax - height[left];
                }
                left++;
            }else{
                if (height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    ans += rightMax - height[right];
                }
                right--;
            }

        }
        return ans;
    }
}
