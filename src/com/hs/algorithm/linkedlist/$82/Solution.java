package com.hs.algorithm.linkedlist.$82;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/09/13 10:54
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode pre = dumpy;
        ListNode cur = pre.next;
        while (cur != null && cur.next != null){
            boolean isD = false;
            while (cur.next != null && cur.val == cur.next.val){
                cur.next = cur.next.next;
                isD = true;
            }
            if (isD){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dumpy.next;
    }
}
