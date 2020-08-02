package com.hs.rpc.demo.server;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/26/0026 11:04
 * @email husheng3921@163.com
 */
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
