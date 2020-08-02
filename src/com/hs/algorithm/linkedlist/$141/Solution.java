package com.hs.algorithm.linkedlist.$141;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC141 环形链表
 * @author hushe
 * @date 2020/4/29/0029 16:43
 * @email husheng3921@163.com
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode temp;
        while (head != null) {
            if (head.next == null && head.val == Integer.MIN_VALUE) {
                return true;
            }
            temp = head.next;
            head.next = null;
            head.val = Integer.MIN_VALUE;
            head = temp;
        }
        return false;

    }
}
