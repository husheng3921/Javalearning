package com.hs.pattern.strategy;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/25/0025 21:47
 * @email husheng3921@163.com
 */
public class StrategyStatefulFactory {
    public static Strategy getStatefulStrategy(String type){
        if ("strategyA".equals(type)){
            return new StartegyA();
        }else if("strategyB".equals(type)){
            return new StartegyB();
        }
        return null;
    }
}
