package com.hs.algorithm.heap.BigFileTopN;

import com.hs.algorithm.heap.BigFileTopN.pojo.KeyBusi;

import java.util.*;

/**
 * TODO
 * 进行分片文件的TopK求解
 * @author hushe
 * @date 2020/4/30/0030 20:17
 * @email husheng3921@163.com
 */
public class CountTopN {
    public static final CountTopN INSTANCE = new CountTopN();
    //进行统计的map操作
    private Map<String, Integer> countMap = new HashMap<>();
    /**定义比较器*/
    private Comparator<KeyBusi> comp = ((o1, o2) -> {
        return o1.getCountNum() - o2.getCountNum();
    });
    public void dataClear(){
        countMap.clear();
    }

    public void putData(String data){
        Integer outValue = countMap.getOrDefault(data, 0);
        outValue++;
        countMap.put(data, outValue);
    }

    /**
     * 求解Topk的问题
     * @param numk
     * @return
     */
    public KeyBusi[] getTopN(int numk){
        PriorityQueue<KeyBusi> topN = new PriorityQueue<>(numk, comp);
        Iterator<Map.Entry<String, Integer>> iterator = countMap.entrySet().iterator();

        Map.Entry<String, Integer> entry;
        while (iterator.hasNext()){
            entry = iterator.next();
            if (topN.size() < numk){
                topN.offer(new KeyBusi(entry.getKey(), entry.getValue()));
            }else{
                //如果当前数据比小顶堆队头大，加入，否则丢弃
                if (topN.peek().getCountNum() < entry.getValue()){
                    topN.poll();
                    topN.offer(new KeyBusi(entry.getKey(), entry.getValue()));
                }
            }
        }
        //结果集
        KeyBusi[] res = new KeyBusi[numk];
        topN.toArray(res);
        return res;
    }

    /**
     * 合并各个TopK 求解
     * @param list
     * @param numk
     * @return
     */
    public KeyBusi[] getTopN(List<KeyBusi[]> list, int numk){
        //进行求解
        PriorityQueue<KeyBusi> topN = new PriorityQueue<>(numk,comp);

        for (KeyBusi[] keys:list){
            for (KeyBusi busi : keys){
                if (busi == null){
                    break;
                }
                if (topN.size() < numk){
                    topN.offer(new KeyBusi(busi.getKey(), busi.getCountNum()));
                }else{
                    //如果当前元素比堆顶元素大，加入
                    if (topN.peek().getCountNum() < busi.getCountNum()){
                        topN.poll();
                        topN.offer(busi);
                    }
                }
            }
        }
        // 结果集
        KeyBusi[] result = new KeyBusi[numk];
        topN.toArray(result);

        return result;
    }

}
