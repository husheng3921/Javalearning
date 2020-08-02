package com.hs.algorithm.linkedlist;

/**
 * TODO
 * 辅助结点ListNode
 * @author hushe
 * @date 2020/4/28/0028 12:38
 * @email husheng3921@163.com
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){ val = x;}
    public static void printList(ListNode head){
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.print("null"+'\n');
    }
}
