package com.hs.algorithm.linkedlist.$23;

import com.hs.algorithm.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO
 * LC23 合并k个排序链表 困难
 * @author hushe
 * @date 2020/5/3/0003 10:33
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 两两合并
     * 第一次合并res的长度为n,
     * 第二次合并res的长度为2*n
     * 第i次合并res的长度为i*n,第i次合并的时间代价O(n+(i-1)*n)=O(i*n)
     * 求和O(k*(1+k)/2 * n)=O(n*k^2) 空间复杂度O(1)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++){
            res = mergeTwoList(res, lists[i]);
        }
        return res;
    }

    /**
     * 两路合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dumpy = new ListNode(-1);
        ListNode pre = dumpy;//移动指针

        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;//有一个链表为空，后面直接赋值指向剩余部分
        return dumpy.next;
    }

    /**
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/
     * 优先队列法 每次插入O(logk),链表长度为N ,循环N次 O(Nlogk);空间复杂度O(k)
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {

        //维持小顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists){//k条链表，堆大小为k
            queue.offer(node);
        }
        if(queue.isEmpty()) return null;//防止空链表
        ListNode dumpy = new ListNode(-1);
        ListNode tail = dumpy;
        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();//返回最小并出堆
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null){
                queue.offer(minNode.next);//继续取当前最小节点后面的结点插入最小堆
            }
        }
        return dumpy.next;

    }

    /**
     * 归并排序 O(Nlogk)
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        return merge(lists,0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi){
            return lists[lo];
        }
        int mid = lo + (hi - lo)/2;
        ListNode l1 = merge(lists,lo,mid);
        ListNode l2 = merge(lists,mid + 1, hi);
        return mergeTwoList(l1, l2);
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(5);
        ListNode d1 = new ListNode(7);
        ListNode e1 = new ListNode(9);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;
        e1.next = null;
        ListNode a2 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode c2 = new ListNode(6);
        ListNode d2 = new ListNode(8);
        ListNode e2 = new ListNode(10);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = e2;
        e2.next = null;
       ListNode[] lists={a, a1, a2};
        Solution solution = new Solution();
        ListNode res = solution.mergeKLists1(lists);
        ListNode.printList(res);
    }
}
