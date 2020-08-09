package com.hs.thread.unsafeThread;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 14:47
 */
public class Service3 {
    public void service3(){
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名"+user.name);
        UserContextHolder.holder.remove();

    }
}
