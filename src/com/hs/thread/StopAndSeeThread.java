package com.hs.thread;

public class StopAndSeeThread {
    public static void main(String[] args) {
        m1();
    }
    private static void m1(){
        int a = 999;
        m2();
    }
    private static void m2(){
        int a = 999;
        m3();
    }
    private static void m3(){
        int a = 333;
        m4();
    }
    private static void m4(){
        int a = 444;
        m5();
    }
    private static void m5(){
        int a = 555;
        System.out.println("m5");
    }
}
