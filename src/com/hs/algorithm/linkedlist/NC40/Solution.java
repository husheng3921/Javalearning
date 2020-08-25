package com.hs.algorithm.linkedlist.NC40;

import com.hs.algorithm.linkedlist.ListNode;

import java.util.Stack;

/**
 * Created by husheng02.
 *
 * @author <a href="mailto:husheng3921@163.com">胡圣</a>
 * @date 2020/08/15 15:33
 */
public class Solution {

    public ListNode addList(ListNode head1, ListNode head2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null){
            s1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null){
            s2.push(head2.val);
            head2 = head2.next;
        }
        int ca = 0;
        int n = 0;
        int n1 = 0;
        int n2 = 0;
        ListNode node = null, pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n % 10);
            node.next = pre;
            ca = ca /10;
        }
        if(ca == 1){
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return node;
    }
}
