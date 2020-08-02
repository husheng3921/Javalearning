package com.hs.algorithm.bfsdfs.$752;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * TODO
 * LC 752
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485134&idx=1&sn=fd345f8a93dc4444bcc65c57bb46fc35&chksm=9bd7f8c6aca071d04c4d383f96f2b567ad44dc3e67d1c3926ec92d6a3bcc3273de138b36a0d9&scene=21#wechat_redirect
 * @author hushe
 * @date 2020/4/23/0023 16:22
 * @email husheng3921@163.com
 */
public class Solution {

    public static void main(String[] args) {
        String[] deadends = {"8888"};
        String target = "0009";
        deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        target = "0202";
        int res = (new Solution()).openLock(deadends, target);
        System.out.println(res);
    }
    //将s[j]向上波动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    //将s[j]向下拨动一次
    String minsOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
    public int openLock(String[] deadends, String target) {
        //记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        //记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        //从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散*/
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                /*判断是否到达终点 */
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minsOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;//增加步数
        }
        return -1;
    }
    public int openLock1(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        //用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int  step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用temp存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将q1中的所有节点向周围扩散*/
            for (String cur : q1) {
                /* 判断是否到达终点*/
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;
                visited.add(cur);

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minsOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
}
