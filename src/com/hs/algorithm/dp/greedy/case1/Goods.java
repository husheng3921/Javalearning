package com.hs.algorithm.dp.greedy.case1;

/**
 * TODO
 * 极客时间 数据结构与算法之美 王争 贪心算法
 * @author hushe
 * @date 2020/5/2/0002 9:43
 * @email husheng3921@163.com
 */
public class Goods {
    /**物品的名称*/
    private String name;
    /**重量*/
    private int weight;
    /**总价值*/
    private float value;
    /**单价*/
    private float unitPrice;

    public Goods(String name, int wight, float value) {
        this.name = name;
        this.weight = wight;
        this.value = value;
        // 计算物品单价
        this.unitPrice = value / wight;
    }

    public Goods(String name, int wight, float value, float unitPrice) {
        this.name = name;
        this.weight = wight;
        this.value = value;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWight() {
        return weight;
    }

    public void setWight(int wight) {
        this.weight = wight;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Goods{");
        sb.append("name='").append(name).append('\'');
        sb.append(", wight=").append(weight);
        sb.append(", value=").append(value);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append('}');
        return sb.toString();
    }
}
