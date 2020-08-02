package com.hs.algorithm.linkedlist.$86;

import com.hs.algorithm.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * TODO
 * LC86 分割链表
 * @author hushe
 * @date 2020/4/27/0027 11:38
 * @email husheng3921@163.com
 */
public class Solution {

    public ListNode partition(ListNode head, int x){
        ListNode beforeHead = new ListNode(-1);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(-1);
        ListNode after = afterHead;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x) {
                before.next = cur;
                before = before.next;
            }else {
                after.next = cur;
                after = after.next;
            }
            cur = cur.next;
        }
        //尾指针指向null
        after.next = null;
        //前链表链接后链表
        before.next = afterHead.next;
        //返回新链表
        return beforeHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d= new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        ListNode res = (new Solution()).partition(a, 3);
        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.print("null");
    }
}
