package com.hs.thread.unsafeThread;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 14:47
 */
public class Service2 {
    public void service2(){
        User user = UserContextHolder.holder.get();
        System.out.println("Service2 拿到用户名"+ user.name);
        new Service3().service3();

    }
}
