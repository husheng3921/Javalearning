package com.hs.thread.stop;


/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/01 8:59
 */
public class VolatileCanStop implements Runnable {
    private volatile boolean canceled = false;
    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceled && num <= 10000){
                if(num % 10 == 0){
                    System.out.println(num + "是10的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileCanStop r = new VolatileCanStop();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(3000);
        r.canceled = true;
    }
}
