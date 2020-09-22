package com.hs.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/17 10:01
 */
public class Question10 {
    static ExecutorService executorService = newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        //考点一：HashMap在只读情况下，线程(并发）是安全的
        Map<String, Integer> map = new HashMap<>();
        map.put("A",1);
        action(map);
        //考点五：合理关闭线程池
        executorService.shutdown();
    }

    private static void action(Map<String, Integer> map) throws Exception {
        Future<Integer> future = executorService.submit(()->map.get("A"));
        //考点二： Future#get() 方法是同步阻塞，必须执行完成
        Integer value = future.get();
        // 考点三 Boxing 和 UNBoxing
        //考点四：Integer -128到127 cache
        System.out.println(value == 1);
    }
}
