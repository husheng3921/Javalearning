package com.hs.algorithm.stack.$20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * TODO
 * LC 20 有效的括号
 * @author hushe
 * @date 2020/4/28/0028 14:54
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean isValid(String s) {
        if (s.length() < 1){
            return true;//空或一个字符肯定无效
        }
        Stack<Character> stack = new Stack<>();//栈
        Map<Character, Character> map = new HashMap<>(4);
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        char[] schar = s.toCharArray();
        for (char item : schar){
            if (item == '('||item =='{' || item =='['){
                //入栈
                stack.push(item);
            }else {
                if (stack.empty()){//开始进来就是}或)或]
                    return false;
                }else{
                    //栈顶元素与当前元素是否匹配
                    if (stack.peek() == map.get(item)){
                        stack.pop();//出栈
                    }else {//不配直接返回false
                        return false;
                    }
                }
            }
        }
        return stack.empty();//最后检查栈是否为空，空则有效
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()(){}"));
        System.out.println(solution.isValid("()}"));
    }
}
