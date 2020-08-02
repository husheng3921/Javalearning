package com.hs.algorithm.linkedlist.$234;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC234 回文链表 简单
 * @author hushe
 * @date 2020/5/8/0008 21:26
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        //找到中点
        ListNode slow = head, fast = head, cur = head;
        //快慢指针找到中点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null){
            if (left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while (cur!= null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
