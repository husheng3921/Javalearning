package com.hs.algorithm.dp.greedy.case1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO
 * 用于计算在重量100的前提下，价值最大化
 * @author hushe
 * @date 2020/5/2/0002 9:46
 * @email husheng3921@163.com
 */
public class Solution {

    //大顶堆
    private PriorityQueue<Goods> goodsList = new PriorityQueue<>(((o1, o2) -> {
        if (o1.getUnitPrice() < o2.getUnitPrice()){
            return 1;
        }else if (o1.getUnitPrice() > o2.getUnitPrice()){
            return -1;
        }
        return 0;
    }));

    public void addGoods(Goods gs){
        this.goodsList.add(gs);
    }

    public List<Goods> getMaxValueGoods(int weight){
        List<Goods> list = new ArrayList<>();

        //首先初始化最大重量
        int surplus = weight;

        while (!goodsList.isEmpty()){
            Goods goodItem = goodsList.poll();//堆顶元素

            //容量够，装该豆子全部重量
            if (surplus >= goodItem.getWight()){
                surplus = surplus - goodItem.getWight();
                list.add(goodItem);
            }else {
                //容量不够，装剩下的重量
                int surplusVals = goodItem.getWight() - surplus;
                goodItem.setWight(surplusVals);
                goodsList.offer(goodItem);
                Goods result = new Goods(goodItem.getName(), surplus,goodItem.getValue(), goodItem.getUnitPrice());
                list.add(result);
                break;
            }
        }
        return list;
    }
}
