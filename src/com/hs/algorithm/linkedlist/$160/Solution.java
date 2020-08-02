package com.hs.algorithm.linkedlist.$160;

import com.hs.algorithm.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * 相交链表 简单
 * @author hushe
 * @date 2020/7/18/0018 17:51
 * @email husheng3921@163.com
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Set<ListNode> s = new HashSet<>();
        while (headA != null){
            s.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (s.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     * 双指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode get2(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        ListNode pa = headA, pb = headB;
        while (pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }
}
