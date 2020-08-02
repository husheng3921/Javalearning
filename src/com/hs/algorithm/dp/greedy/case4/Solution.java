package com.hs.algorithm.dp.greedy.case4;

import com.hs.algorithm.dp.greedy.case1.Goods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/5/2/0002 10:23
 * @email husheng3921@163.com
 */
public class Solution {
    //从小到大排列终点
  private PriorityQueue<ScopeBusi> scopeList = new PriorityQueue<>((o1, o2) -> o1.getEnd() - o2.getEnd());

  public List<ScopeBusi> countScope( ){
      ScopeBusi scopeBusiTmp = scopeList.poll();
      List<ScopeBusi> result = new ArrayList<>();
      result.add(scopeBusiTmp);
      while (!scopeList.isEmpty()){
          ScopeBusi endBusi = scopeList.poll();//继续取堆顶元素
          if (endBusi.getStart() >= scopeBusiTmp.getEnd()){//如果该区间的开始值大于临时区间尾结点，则
              result.add(endBusi);
              scopeBusiTmp = endBusi;
          }
      }
      return result;
  }

  //按起点从小到大
  private PriorityQueue<ScopeBusi> scopeStartList = new PriorityQueue<>((o1, o2) -> o1.getStart() - o2.getStart());

    /**
     * 行不通
     * @return
     */
  public List<ScopeBusi> countScope1(){
      ScopeBusi tmp = scopeStartList.poll();//取堆顶元素
      List<ScopeBusi> resList = new ArrayList<>();

      while (!scopeStartList.isEmpty()){
          ScopeBusi nextScope = scopeStartList.poll();//取下一个元素
          if (nextScope.getStart() >= tmp.getStart() && nextScope.getEnd() <= tmp.getEnd() || nextScope.getStart() >= tmp.getEnd()){
              resList.add(nextScope);
          }
          tmp = nextScope;
      }
      return resList;
  }

    public static void main(String[] args) {
        ScopeBusi scopeBusi = new ScopeBusi(1,5);
        Solution solution = new Solution();
        solution.scopeList.offer(scopeBusi);
        solution.scopeStartList.offer(scopeBusi);
        scopeBusi = new ScopeBusi(3, 5);
        solution.scopeList.offer(scopeBusi);
        solution.scopeStartList.offer(scopeBusi);
        scopeBusi = new ScopeBusi(5, 9);
        solution.scopeList.offer(scopeBusi);
        solution.scopeStartList.offer(scopeBusi);
        scopeBusi = new ScopeBusi(6, 8);
        solution.scopeList.offer(scopeBusi);
        solution.scopeStartList.offer(scopeBusi);
        scopeBusi = new ScopeBusi(8, 10);
        solution.scopeList.offer(scopeBusi);
        solution.scopeStartList.offer(scopeBusi);
        scopeBusi = new ScopeBusi(2, 4);
        solution.scopeList.offer(scopeBusi);
        solution.scopeStartList.offer(scopeBusi);
        List<ScopeBusi> res = solution.countScope();
        Iterator<ScopeBusi> iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        List<ScopeBusi> res1 = solution.countScope1();
        Iterator<ScopeBusi> iterator1 = res1.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
