package com.hs.algorithm.linkedlist.$25;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC25 k个一组翻转链表 困难
 *
 * @author hushe
 * @date 2020/5/3/0003 9:59
 * @email husheng3921@163.com
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode(-1);//辅助头结点
        dumpy.next = head;

        ListNode pre = dumpy;
        ListNode end = dumpy;
        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) end = end.next;//从虚拟头结点开始，找到待翻转的尾结点end
            if (end == null) break;

            ListNode nextNode = end.next;//下次翻转的头结点
            ListNode start = pre.next;//本次翻转的头结点
            end.next = null;//拆开链表
            pre.next = reverse(start);//连接翻转后的链表
            start.next = nextNode;//翻转后头结点变为尾结点，连接后面的链表
            pre = start;//移动前指针到本次翻转结点尾，下次链接链表

            end = pre;//下次开始寻找尾结点的起点
        }
        return dumpy.next;//返回新链表
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
        Solution solution = new Solution();
        ListNode res = solution.reverseKGroup(a, 2);
        ListNode.printList(res);
    }
}
