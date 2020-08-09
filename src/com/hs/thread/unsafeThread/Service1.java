package com.hs.thread.unsafeThread;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 14:47
 */
public class Service1 {
    public void service1(String name){
        User user = new User(name);
        UserContextHolder.holder.set(user);
        new Service2().service2();
    }
}
