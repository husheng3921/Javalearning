package com.hs.algorithm.linkedlist.$142;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * Created by husheng02.
 * 环形链表入口
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/15 14:30
 */
public class Solution {
    public ListNode detectCycle(ListNode head){
        ListNode fast = head, slow = head;
        while (true){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
