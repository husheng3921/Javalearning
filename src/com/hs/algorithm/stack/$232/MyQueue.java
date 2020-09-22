package com.hs.algorithm.stack.$232;

import java.util.Stack;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/20 14:00
 */
public class MyQueue {
    //元素必须进栈1
    Stack<Integer> stack1 = new Stack<>();
    //从出栈2出倒序
    Stack<Integer> stack2 = new Stack<>();
    public MyQueue(){

    }
    public void push(int x){
        stack1.push(x);
    }
    public int pop(){
        //stack2探出元素
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                //从栈1弹出元素到栈2
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}
