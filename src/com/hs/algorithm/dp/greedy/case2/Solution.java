package com.hs.algorithm.dp.greedy.case2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/2/0002 10:02
 * @email husheng3921@163.com
 */
public class Solution {

    /** 糖果队列，用糖果的大小来排序，按从小到大来满足 */
    private PriorityQueue<Sweet> sweetsQueue =
            new PriorityQueue<>(
                    (o1, o2) -> {
                        if (o1.getType() > o2.getType()) {
                            return 1;
                        } else if (o1.getType() < o2.getType()) {
                            return -1;
                        }
                        return 0;
                    });
    /** 孩子对象集 */
    private PriorityQueue<Child> childQueue =
            new PriorityQueue<>(
                    (o1, o2) -> {
                        if (o1.getType() > o2.getType()) {
                            return 1;
                        } else if (o1.getType() < o2.getType()) {
                            return -1;
                        }
                        return 0;
                    });
    /**
     * 添加糖果信息
     *
     * @param name 名称
     * @param num 数量
     * @param type 类型，
     */
    public void addSweet(String name, int num, int type) {
        this.sweetsQueue.offer(new Sweet(name, num, type));
    }

    /**
     * 添加孩子信息，以及期望的糖果
     *
     * @param name 孩子的名称
     * @param type 类型信息
     */
    public void addChild(String name, int type) {
        this.childQueue.offer(new Child(name, type));
    }

    public List<Child> alloc(){
        List<Child> childList = new ArrayList<>();

        //孩子与糖果都按糖果的类型来排列，满足孩子的最小期望
        while (!sweetsQueue.isEmpty()){
            Sweet sweetItem = sweetsQueue.poll();

            //检查数量
            if (sweetItem.getNum() > 0){
                while (!childQueue.isEmpty()){
                    Child childItem = childQueue.poll();
                    //尽量让满足多的孩子拿到期望的糖果
                    if (sweetItem.getType()==childItem.getType()){
                        childItem.setSweet(sweetItem);
                        childList.add(childItem);
                        break;
                    }
                }
                sweetItem.setNum(sweetItem.getNum() - 1);
                sweetsQueue.offer(sweetItem);
            }
        }
        return childList;
    }
}
