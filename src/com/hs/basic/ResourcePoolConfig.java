package com.hs.basic;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/13/0013 9:57
 * @email husheng3921@163.com
 */
public class ResourcePoolConfig {
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDEL = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDEL;

    public ResourcePoolConfig(String name, int maxTotal, int maxIdle, int minIdle) {
        this.name = name;
        this.maxTotal = maxTotal;
        this.maxIdle = maxIdle;
        this.minIdle = minIdle;
    }

    public static int getDefaultMaxTotal() {
        return DEFAULT_MAX_TOTAL;
    }

    public static int getDefaultMaxIdle() {
        return DEFAULT_MAX_IDLE;
    }

    public static int getDefaultMinIdel() {
        return DEFAULT_MIN_IDEL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
