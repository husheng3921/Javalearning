package com.hs.thread.lock;

import com.hs.thread.$4.Interrupted;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 9:44
 */
public class ReadWriteLockDemo {
    private static final ReentrantReadWriteLock re = new ReentrantReadWriteLock(false);
    private static final ReentrantReadWriteLock.ReadLock readLock = re.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = re.writeLock();

    private static void read(){
        readLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到锁，正在读取");
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放读锁");
            readLock.unlock();
        }
    }
    private static void write(){
        writeLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"得到写锁，正在写入");
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(()->read()).start();
        new Thread(()->read()).start();
        new Thread(()->write()).start();
        new Thread(()->write()).start();
    }
}
