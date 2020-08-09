package com.hs.thread;

import java.lang.management.ThreadInfo;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 13:26
 */
public class VisibilityProblem {
    int a = 10;
    int b = 20;
    private void change(){
        a = 30;
        b =a;
    }
    private void print(){
        System.out.println("b= "+b+"; a="+a);
    }

    public static void main(String[] args) {
        while (true){
            VisibilityProblem problem = new VisibilityProblem();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    problem.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    problem.print();
                }
            }).start();
        }
    }
}
