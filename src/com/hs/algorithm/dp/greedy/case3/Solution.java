package com.hs.algorithm.dp.greedy.case3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/2/0002 10:10
 * @email husheng3921@163.com
 */
public class Solution {

    //大顶堆，从到小排列，用于存储金额的信息
    private PriorityQueue<MoneyBusi> moneyQueue = new PriorityQueue<>((o1, o2) -> o2.getMemory() - o1.getMemory());

    /**
     * 添加金额信息
     * @param value 面值信息
     * @param num 张数
     * @param memory  金额值
     */
    public void addMoneyInfo(String value, int num, int memory){
        moneyQueue.offer(new MoneyBusi(value, num, memory));
    }

    /**
     * 计算找零钱的问题
     * @param money
     * @return
     */
    public List<MoneyBusi> looseChange(int money){
        List<MoneyBusi> resultMemory = new ArrayList<>();

        List<MoneyBusi> moreMemory = new ArrayList<>();

        int surplus = money;

        while (surplus > 0){
            MoneyBusi busi = moneyQueue.peek();
            if (busi !=null){
                if (busi.getMemory() <= surplus){
                    busi = moneyQueue.poll();
                    surplus = surplus - busi.getMemory();

                    MoneyBusi busiNew = new MoneyBusi(busi.getValue(),1,busi.getMemory());
                    resultMemory.add(busiNew);
                    busi.setNum(busi.getNum() - 1);
                    if (busi.getNum() > 0){
                        moneyQueue.offer(busi);
                    }
                }else {
                    moreMemory.add(moneyQueue.poll());
                }
            }else{
                break;
            }
        }
        moneyQueue.addAll(moreMemory);
        return resultMemory;
    }
}
