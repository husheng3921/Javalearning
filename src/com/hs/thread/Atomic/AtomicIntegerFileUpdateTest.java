package com.hs.thread.Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 16:51
 */
public class AtomicIntegerFileUpdateTest {

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) {
        /**
         * 设置柯南基本信息
         */
        User conan = new User("conan", 10);
        //柯南账一岁
        System.out.println(a.getAndIncrement(conan));
        //输出柯南现在的年龄
        System.out.println(a.get(conan));
    }
    static class User{
        private String name;
        public volatile int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
