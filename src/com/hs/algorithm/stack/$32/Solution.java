package com.hs.algorithm.stack.$32;

import com.hs.thread.communication.wait.comsummer.C;

import java.util.Stack;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/10 20:31
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxAns = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }
    public int longestValidParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()){
                    stack.push(s.charAt(i));
                }else{
                    if(stack.peek()=='('){
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }

                }
            }
        }
        int size = stack.size();
        return s.length() - size;
    }
}
