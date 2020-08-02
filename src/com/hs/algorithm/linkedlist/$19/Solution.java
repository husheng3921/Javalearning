package com.hs.algorithm.linkedlist.$19;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC删除链表倒数第N个结点 中等
 * @author hushe
 * @date 2020/4/29/0029 16:45
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     * 不能解决空指针问题，即单个元素删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow = head, fast = head;
        while (n >0){
            fast = fast.next;
            n --;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
       /* ListNode delNode = slow.next;
        ListNode nextNode = slow.next.next;
        slow.next = nextNode;*/
        //当只有一个元素是[1] 1无法解决
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 链表删除问题引入辅助头结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n){
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode slow = dumpy, fast = dumpy;//快慢指针
        //快指针多走n步
        while (n > 0){
            fast = fast.next;
            n --;
        }
        //要确保fast指向末尾元素(非空),则fast.next!=null,此时fast!=null
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 有辅助头结点，保证单个元素时slow.next不为空
        slow.next = slow.next.next;
        return dumpy.next;
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
        ListNode res = s.removeNthFromEnd(a, 0);
        ListNode.printList(res);
    }
}
