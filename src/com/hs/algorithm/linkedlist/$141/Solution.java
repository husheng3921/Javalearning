package com.hs.algorithm.linkedlist.$141;

import com.hs.algorithm.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * LC141 环形链表
 * @author hushe
 * @date 2020/4/29/0029 16:43
 * @email husheng3921@163.com
 */
public class Solution {
    //hash,Set不重复元素
    public boolean hasCycle(ListNode head) {

        Set<ListNode> nodes = new HashSet<>();
        while (head != null){
            if (nodes.contains(head)){
                return true;
            }else{
                nodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        //快慢指针
        ListNode slow = head;
        ListNode fast = head.next;//只有两个结点时无环，
        while (slow != fast){
            if (fast == null ||fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public boolean hasCycle2(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        //快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
