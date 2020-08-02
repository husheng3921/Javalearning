package com.hs.algorithm.linkedlist.$21;

/**
 * TODO
 * LC21 合并两个有序链表
 * @author hushe
 * @date 2020/4/27/0027 8:59
 * @email husheng3921@163.com
 */
public class Solution {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;//移动指针
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = null;
        ListNode aa = new ListNode(1);
        ListNode bb = new ListNode(3);
        ListNode cc = new ListNode(4);
        aa.next = bb;
        bb.next = cc;
        cc.next = null;
        ListNode res = (new Solution().mergeTwoList(a, aa));
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
