package com.hs.thread.unsafeThread;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/08 14:49
 */
public class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}
