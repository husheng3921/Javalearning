package com.hs.algorithm.heap.$231;

import java.util.Stack;

/**
 * TODO
 * 232 用栈实现队列，两个栈，第一栈保持栈顶是最先进的元素
 * 故栈1先出栈再入栈栈2，栈二栈顶是上次最新插入的，我们继续插入当前最新元素，
 * 然后再将栈2出栈，入栈栈1，确保了栈顶元素是最开始入栈的元素，即先进先出
 * @author hushe
 * @date 2020/7/24/0024 21:59
 * @email husheng3921@163.com
 */
public class MyQueue {
    private int front;//队首元素
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    public MyQueue(){

    }

    /**
     * 先将s1搬到s2,插入s2新元素，再搬回s1，确保新插入的元素在栈底，就是最后出栈
     * @param x
     */
    public void push(int x){
        if (s1.isEmpty()){
            front = x;//栈空时，第一个元素，队首
        }
        //先搬迁到s2,
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        //插入s2
        s2.push(x);
        //逆转s2,确保s1,上到下是先进先出
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    public int pop(){
        //弹出队首,更新队首
        int temp = -1 ;
        if (!s1.isEmpty()){
            temp = front;
            s1.pop();
            if (!s1.isEmpty()){
                front = s1.peek();
            }
        }
        return temp;
    }
    public int peek(){
        //获取队首元素
        return front;
    }
    public boolean empty(){
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.pop();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());
    }
}
