package com.hs.algorithm.linkedlist.$206;

import com.hs.algorithm.linkedlist.ListNode;

import java.sql.SQLOutput;

/**
 * TODO
 *LC 206链表反转
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author hushe
 * @date 2020/4/29/0029 15:59
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 有问题
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode preNode = newHead, nextNode = null, curNode = head, tmpNode = null;
        while (curNode != null && curNode.next != null) {
            nextNode = curNode.next;
            tmpNode = nextNode.next;

            curNode.next = tmpNode.next;
            nextNode.next = curNode;
            newHead.next = nextNode;
            preNode.next = nextNode;
           preNode = nextNode;
           curNode = tmpNode;
        }
        return newHead.next;
    }

    /**
     * 经典解法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        ListNode pre = null, cur = head, nextNode = null;
        while(cur != null){
            nextNode = cur.next;
            cur.next = pre;//指向前一节点
            pre = cur;//移动更新节点
            cur = nextNode;

        }
        return pre;
    }

    /**
     * 递归 O(N) O(N)
     * @param head
     * @return
     */
    public ListNode resverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = resverseList2(head.next);
        head.next.next = head;//下下个结点指向头
        head.next = null;
        return cur;
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
        d.next = e;
        e.next = null;
        Solution s = new Solution();
        ListNode res = s.reverseList(a);
        ListNode.printList(res);

    }
}
