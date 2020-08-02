package com.hs.algorithm.interview;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * 链表中点问题，奇数返回中间，偶数返回第二个中间数
 * @author hushe
 * @date 2020/4/22/0022 12:50
 * @email husheng3921@163.com
 */
public class Solution1 {

    public ListNode middleNode(ListNode head){
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int k = 0;
        cur =head;
        while (k < n/2){
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 时间复杂度O(N),空间复杂度O(1)
     * @param head
     * @return
     */
    public ListNode midNode1(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode midNode2(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        d.next = null;
        e.next = null;
        ListNode res = (new Solution1()).midNode1(a);
        System.out.println(res.val);
        ListNode res2 = (new Solution1()).midNode2(a);
        System.out.println(res2.val);
    }
}
