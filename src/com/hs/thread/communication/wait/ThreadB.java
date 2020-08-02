package com.hs.thread.communication.wait;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/16/0016 16:04
 * @email husheng3921@163.com
 */
public class ThreadB extends Thread{
    private Object lock;
    private MyList list;

    public ThreadB(Object lock, MyList list) {
        super();
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                for (int i = 0; i < 10; i++){
                    list.add();

                if (list.size() == 5){
                   //System.out.println("wait begin:"+ System.currentTimeMillis());
                    lock.notify();//唤醒被阻塞线程，必须执行完同步块才释放锁，所以是打印完后才wait阻塞的线程才运行
                    System.out.println("通知已经发出");
                }
                    System.out.println("添加了"+(i+1)+"个元素");
                Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
