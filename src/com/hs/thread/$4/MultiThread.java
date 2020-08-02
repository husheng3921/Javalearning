package com.hs.thread.$4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/11/0011 14:46
 * @email husheng3921@163.com
 */
public class MultiThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo info: threadInfos){
            System.out.println("["+ info.getThreadId()+"]" + info.getThreadName());
        }
    }
}
