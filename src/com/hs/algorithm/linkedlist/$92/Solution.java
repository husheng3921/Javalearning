package com.hs.algorithm.linkedlist.$92;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC 92 链表反转II 从位置m到n链表进行反转，
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * @author hushe
 * @date 2020/4/29/0029 17:10
 * @email husheng3921@163.com
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //空链表
        if (head == null){
            return null;
        }
        ListNode cur = head, pre = null;
        //用于找到反转开始结点和反转结点的前结点
        while (m > 1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = pre, tail = cur;//此时的当前结点cur是反转后的尾结点，暂存；pre点反转前的结点，用于连接

        ListNode third = null;//用来反转临时结点
        //将指针反向指向前
        while (n > 0){
            third = cur.next;
            cur.next = pre;
            pre = cur;
            cur = third;
            n --;
        }
        //1(con)<-2(tail)<-3<-4(pre) 5(cur)
        if (con != null){
            con.next = pre;//1->4->3->2(tail)
        }else {
            head = pre;
        }
        tail.next = cur;
        return head;
    }

}
