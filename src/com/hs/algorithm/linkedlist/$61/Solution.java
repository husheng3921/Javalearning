package com.hs.algorithm.linkedlist.$61;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC 61 旋转链表
 * @author hushe
 * @date 2020/4/28/0028 13:55
 * @email husheng3921@163.com
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = head;
        int n = 0;//链表结点个数
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        k = k % n;
        if (k == 0){
            return head;
        }
        int headIndex = n - k;//从0开始,找到新头结点位置

        ListNode preNode = newHead;//头结点前的结点
        cur = head;
        while (headIndex > 0) {
            preNode = preNode.next;
            cur = cur.next;
            headIndex --;
        }
        preNode.next = null;
        newHead.next = cur;//新头结点赋给虚拟节点后的值
        //然后移动当前指针到尾结点(非null)
        while (cur.next != null){
            cur = cur.next;
        }
        //尾结点连接头结点
        cur.next = head;

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = null;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        //ListNode.printList(a);
        ListNode res = (new Solution()).rotateRight(a, 1);
        ListNode.printList(res);
    }
}
