package com.hs.algorithm.linkedlist.$2;

import com.hs.algorithm.linkedlist.ListNode;

/**
 * TODO
 * LC02
 * @author hushe
 * @date 2020/4/28/0028 20:20
 * @email husheng3921@163.com
 */
public class Solution {
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(-1);
        ListNode curNode = resHead, nextNode = null;
        int temp = 0;//标记进位
        //先计算两链表相同长度的和
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + temp;//两数相加还要加上进位
            nextNode = new ListNode(sum % 10 );//构造新节点，val为取余的结果， (1)
            temp = sum / 10;//整除的结果进1
            //当前结点指向下一个结点
            curNode.next = nextNode;// curNode.next = new ListNode(sum % 10) ;(2)
            //移动指针
            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //获取剩余长的链表l1 或 l2,可能l1与l2均为空
        ListNode cur = l1 == null ? l2 : l1;
        while (cur != null){//进位处理逻辑和上面一样
            int x = cur.val + temp;
            nextNode = new ListNode(x % 10);//取余留在本位，
            temp = x /10;
            //连接节点，前结点指向
            curNode.next = nextNode;
            //移动指针
            curNode = curNode.next;
            cur = cur.next;
        }
        if (temp > 0){//最后一次进位是否产生新节点
            curNode.next = new ListNode(temp);
        }
        return resHead.next;
    }

    /**
     * 参考官方解答
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode resHead = new ListNode(-1);
        ListNode cur = resHead;
        int nextBit = 0;//进位值
        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = nextBit + x + y;
            nextBit = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (nextBit > 0){//判断最后一次是否产生进位，产生则新生成结点
            cur.next = new ListNode(nextBit);
        }
        return resHead.next;
    }
    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(4);
        ListNode c1 = new ListNode(3);
        ListNode d1 = new ListNode(5);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = null;

        ListNode a2 = new ListNode(5);
        ListNode b2= new ListNode(6);
        ListNode c2 = new ListNode(4);
        ListNode d2 = new ListNode(5);
        a2.next = b2;
        b2.next = c2;
        c2.next = d2;
        d2.next = null;

        ListNode res = (new Solution()).addTwoNumbers(a1, a2);
        ListNode.printList(res);
    }
}
