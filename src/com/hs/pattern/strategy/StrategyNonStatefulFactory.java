package com.hs.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/25/0025 22:32
 * @email husheng3921@163.com
 */
public class StrategyNonStatefulFactory {
    private static Map<String, Strategy> map = new HashMap<>();
    static {
        map.put("strategyA", new StartegyA());
        map.put("strategyB", new StartegyB());
    }
    public static Strategy getStrategy(String type){
        return map.get(type);
    }
}
