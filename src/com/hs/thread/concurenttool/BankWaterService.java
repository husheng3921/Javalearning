package com.hs.thread.concurenttool;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 16:01
 */
public class BankWaterService implements Runnable {
    //创建4个屏障
    private CyclicBarrier c = new CyclicBarrier(4, this);
    // 只有4个sheet，启动4个线程
    private ExecutorService threadPool = Executors.newFixedThreadPool(4);
    //保存每个sheet计算出的结果
    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    private void count(){
        for (int i = 0; i<4; i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    map.put(Thread.currentThread().getName(), 1);
                    //计算完成，插入一个屏障
                    try{
                        c.await();
                    }catch (InterruptedException | BrokenBarrierException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result = 0;
        //汇总每个Sheet计算结果
        for(Map.Entry<String, Integer> sheet : map.entrySet()){
            result += sheet.getValue();
        }
        map.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
