package com.hs.algorithm.linkedlist.$24;

import com.hs.algorithm.linkedlist.ListNode;

import java.util.List;

/**
 * TODO
 * LC24 两两交换链表结点
 * @author hushe
 * @date 2020/4/28/0028 12:37
 * @email husheng3921@163.com
 */
public class Solution {

    /**
     * 两两交换结点，不单纯改变结点的值val,要实际改变结点
     * 不改变原始链表，返回新的链表
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);//新虚拟头结点
        newHead.next = head;
        ListNode p1 = head , p2 = null, p3 = null, pre = head;
        boolean flag = true; //标记获取头结点
        while ( p1 != null && p1.next != null){
            p2 = p1.next;
            p3 = p2.next;
            p2.next = p1;
            p1.next = p3;
            if (flag){
                newHead.next = p2;
                flag = false;
            }else {
                pre.next = p2;
            }
            //更新移动指针
            pre = p1;
            p1 = p3;

        }
        return newHead.next;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode swapPairs0(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);//新虚拟头结点
        newHead.next = head;
        ListNode p1 = head , p2 = null, p3 = null, pre = newHead;
        boolean flag = true; //标记获取头结点
        while ( p1 != null && p1.next != null){
            //准备节点p1 p2
            p2 = p1.next;
            p3 = p2.next;
            //反向连接节点，p2->p1
            p2.next = p1;
            // 更新指向
            p1.next = p3;
            pre.next = p2;
            //更新移动指针
            pre = p1;
            p1 = p3;

        }
        return newHead.next;
    }

    /**
     * 基于原始链表修改，改变原始链表
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);//新虚拟头结点
        newHead.next = head;
        //定义前指针用来连接交换后的链段
        ListNode preNode = newHead;
        while (head != null && head.next != null) {
            // 准备交换的结点
            ListNode firthNode = head;
            ListNode secondNode = head.next;

            // 交换工作
            preNode.next = secondNode;//连接头尾
            // 第一个接点连到第三个结点second.next
            firthNode.next = secondNode.next;
            // 连接2->1
            secondNode.next = firthNode;

            //移动首指针，前指针
            preNode = firthNode;
            head = firthNode.next;

        }
        return newHead.next;
    }

    public ListNode swapPairs2(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
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
        ListNode.printList(a);
        ListNode res = (new Solution()).swapPairs0(a);
        ListNode.printList(res);//打印结点


    }
}
