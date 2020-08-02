package com.hs.algorithm.linkedlist.$143;

import com.hs.algorithm.linkedlist.ListNode;

import java.util.List;

/**
 * TODO
 *
 * @author hushe
 * @date 2020/7/5/0005 9:56
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 一头一尾取元素
     * 1、找到链表中点，分成两半
     * 2、将第二个链表逆序
     * 3、依次连接两个链表
     * @param head
     */
    public void reorderList(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return;//null,一个元素，两个元素，不变化
        }
        //定义快慢指针，找到中间结点，奇偶链表
        ListNode slow = head;
        ListNode fast = head;

        /**
         * 下面这种写法，fast.next.next!=null,得到的slow结点，奇数链表中，为中间结点，偶数链表中为中间结点左结点
         * 只有 fast。next ！=null条件时，奇数链表中，为中间结点，偶数链表中为两个中间结点的右节点
         */
        while (fast.next != null && fast.next.next != null){//注意此处终止条件
            fast = fast.next.next;//快指针走两步
            slow = slow.next;//慢指针走一步
        }
        ListNode newHead = slow.next;//获取后一半链表
        slow.next = null;//第一条链表末尾置空

        //链表倒置
        newHead = reverseList(newHead);
        //后一半链表长度小于或等于前一半，这里用
        while (newHead != null){
            ListNode tmp = newHead.next;
            newHead.next = head.next;//新节点指向头结点一个结点，插入1
            head.next = newHead;//当前头结点指向新节，点插入连接2
            head = newHead.next;//更新新的头结点
            newHead = tmp;//向后移动结点
        }
    }

    //翻转链表
    private ListNode reverseList(ListNode head){
        ListNode cur = head, pre = null, nextNode ;
        while (cur != null){
            nextNode = cur.next;
            cur.next = pre;
            pre = cur;//移动更新
            cur = nextNode;
        }
        return pre;
    }

}
