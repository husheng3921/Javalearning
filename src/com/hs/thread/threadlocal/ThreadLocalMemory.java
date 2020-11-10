package com.hs.thread.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/27 16:01
 */
public class ThreadLocalMemory {
    public ThreadLocal<List<Object>> threadId = new ThreadLocal<List<Object>>(){
        @Override
        protected List<Object> initialValue() {
            List<Object> list = new ArrayList<>();
            for (int i = 0; i < list.size(); i++){
                list.add(String.valueOf(i));
            }
            return list;
        }
    };
    public List<Object> get(){
        return threadId.get();
    }
    public void remove(){
        threadId.remove();
    }

    public static void main(String[] args) {
        ThreadLocalMemory threadLocalMemory = new ThreadLocalMemory();
        incrementSameThreadId(threadLocalMemory);
        System.out.println("GC前key: "+threadLocalMemory.threadId);
        System.out.println("GC前： value-size");
    }
    private static void incrementSameThreadId(ThreadLocalMemory memory){
        try{
            for(int i  = 0; i < 5; i++){
                System.out.println(Thread.currentThread()+"_"+",threadId"+memory.threadId.get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
