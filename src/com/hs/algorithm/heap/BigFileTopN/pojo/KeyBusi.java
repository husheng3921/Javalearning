package com.hs.algorithm.heap.BigFileTopN.pojo;

/**
 * TODO
 * 关键字信息
 * @author hushe
 * @date 2020/4/30/0030 19:51
 * @email husheng3921@163.com
 */
public class KeyBusi {
    /** 关键字*/
    private String key;
    /** 出现次数*/
    private int countNum;

    public KeyBusi(String key, int countNum) {
        this.key = key;
        this.countNum = countNum;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("KeyBusi{");
        sb.append("key='").append(key).append('\'');
        sb.append(", countNum=").append(countNum);
        sb.append('}');
        return sb.toString();
    }
}
