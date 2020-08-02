package com.hs.Proxy;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO
 * JDK Proxy
 * @author hushe
 * @date 2020/4/18/0018 15:42
 * @email husheng3921@163.com
 */
public class JDKProxy {

    static interface Car {
        void running();
    }
    static class Bus implements Car{

        @Override
        public void running() {
            System.out.println("The bus is running");
        }
    }
    static class Taxi implements Car{

        @Override
        public void running() {
            System.out.println("the Taxi is running");
        }
    }

    /**
     * JDK 代理类
     */
    static class JDKProxyTest implements InvocationHandler{
        private Object target;//这个是我们要代理的真实对象
        //获取到代理对象
        public Object getInstance(Object target) {
            this.target = target;
            //取得代理对象
            return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        }

        /**
         *  执行代理方法
         * @param proxy 代理对象
         * @param method 代理方法
         * @param args 方法的参数数组
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("动态代理之前的业务处理");
            Object result = method.invoke(target,args);
            System.out.println("动态代理之后的业务处理");
            return result;
        }
    }

    public static void main(String[] args) {
        JDKProxyTest jdkProxyTest = new JDKProxyTest();
        Car carInstance = (Car) jdkProxyTest.getInstance(new Taxi());
        carInstance.running();
    }

}
