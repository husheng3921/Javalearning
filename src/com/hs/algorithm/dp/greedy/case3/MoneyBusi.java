package com.hs.algorithm.dp.greedy.case3;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/2/0002 10:10
 * @email husheng3921@163.com
 */
public class MoneyBusi {
    /** 面值 */
    private String value;

    /** 张数 */
    private int num;

    /** 金额 */
    private int memory;

    public MoneyBusi(String value, int num, int memory) {
        this.value = value;
        this.num = num;
        this.memory = memory;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MoneyBusi{");
        sb.append("value='").append(value).append('\'');
        sb.append(", num=").append(num);
        sb.append(", memory=").append(memory);
        sb.append('}');
        return sb.toString();
    }
}
