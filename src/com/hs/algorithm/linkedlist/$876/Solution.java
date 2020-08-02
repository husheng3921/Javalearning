package com.hs.algorithm.linkedlist.$876;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC876 中间结点 ，奇数返回中间，偶数返回第二个,起点均为head
 * @author hushe
 * @date 2020/4/29/0029 16:46
 * @email husheng3921@163.com
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;//快慢指针
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
