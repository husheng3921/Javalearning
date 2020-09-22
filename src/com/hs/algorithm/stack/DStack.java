package com.hs.algorithm.stack;

import java.util.Stack;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/15 17:56
 */
public class DStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public DStack(){

    }
    public void addTail(int value){
        stack1.push(value);
    }
    public int deleteHead(){

        if(!stack2.isEmpty()){
           return stack2.pop();
        }else{
            while (!stack1.isEmpty()){
                System.out.println(stack1.peek()+"---");
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        DStack stack = new DStack();
        stack.addTail(1);
        stack.addTail(2);
        System.out.println(stack.deleteHead());
        System.out.println(stack.deleteHead());
    }
}
