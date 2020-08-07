package com.hs.thread.Atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/07 16:47
 */
public class AtomicReferenceTest {
    static AtomicReference<User> atomicuser = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("husheng", 23);
        atomicuser.set(user);
        User updateUser = new User("whu",100);
        atomicuser.compareAndSet(user, updateUser);
        System.out.println(atomicuser.get().getAge());
        System.out.println(atomicuser.get().getName());
    }
    static class User{
        private String name;
        private int age;

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
