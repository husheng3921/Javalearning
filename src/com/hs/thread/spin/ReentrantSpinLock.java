package com.hs.thread.spin;


import com.hs.thread.communication.wait.comsummer.$2.ThreadP;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/01 9:32
 */
public class ReentrantSpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();
    private int count = 0;
    public void lock(){
        Thread t = Thread.currentThread();
        if(t == owner.get()){
            ++count;
            return;
        }
        while (!owner.compareAndSet(null, t)){
            System.out.println("自旋");
        }
    }
    public void unlock(){
        Thread t = Thread.currentThread();
        if(t == owner.get()){
            if (count > 0){
                --count;
            }else{
                owner.set(null);
            }
        }
    }

    public static void main(String[] args) {
        ReentrantSpinLock r = new ReentrantSpinLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始自旋");
                r.lock();
                System.out.println(Thread.currentThread().getName() + "获取自旋");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    r.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放了自旋");
                }

            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
