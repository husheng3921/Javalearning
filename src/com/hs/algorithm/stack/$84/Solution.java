package com.hs.algorithm.stack.$84;

import sun.nio.cs.ext.MacArabic;

import java.util.Stack;

/**
 * LC84 最大矩形面积
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxera = 0, temp = 0;
        for(int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                 temp = heights[stack.pop()] * (i - stack.peek()-1);
                maxera = Math.max(maxera, temp);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
             temp = heights[stack.pop()] * (heights.length - stack.peek()-1);
            maxera = Math.max(maxera,temp);
        }
        return maxera;
    }

    public void maxMartix(int[] heights) {
        int n = heights.length;
        int []s = new int[1005];
        int top = -1;
        int[] l = new int[1005];
        int[] r = new int[1005];
    }
}
