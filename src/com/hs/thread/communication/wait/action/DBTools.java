package com.hs.thread.communication.wait.action;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 18:19
 * @email husheng3921@163.com
 */
public class DBTools {

    private volatile boolean prevIsA = false;

    public synchronized void backupA(){
        try{
            while (prevIsA == true){
                wait();
            }
            for (int i = 0; i < 5; i++){
                System.out.println("@@@@@@");
            }
            prevIsA = true;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void backupB(){
        try{
            while (prevIsA == false){
                wait();
            }
            for (int i = 0; i < 5; i++){
                System.out.println("#####");
            }
            prevIsA = false;
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
