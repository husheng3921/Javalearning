package com.hs.algorithm.dp.greedy.case2;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/2/0002 10:02
 * @email husheng3921@163.com
 */
public class Child {
    /** 孩子的名称 */
    private String name;

    /** 想要的糖果的大小 */
    private int type;

    /** 分配的糖果信息 */
    private Sweet sweet;

    public Child(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Sweet getSweet() {
        return sweet;
    }

    public void setSweet(Sweet sweet) {
        this.sweet = sweet;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Child{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", sweet=").append(sweet);
        sb.append('}');
        return sb.toString();
    }
}
