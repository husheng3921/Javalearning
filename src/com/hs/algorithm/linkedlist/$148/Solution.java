package com.hs.algorithm.linkedlist.$148;

/**
 * TODO
 * LC148 排序链表
 * @author hushe
 * @date 2020/4/27/0027 9:26
 * @email husheng3921@163.com
 */
public class Solution {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }

    /**
     * 归并排序 时间空间均为O(nlogn)
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;//快慢指针,找中间链表
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;//分割成2个链表

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        //合并有序链表
        while (left != null && right != null) {
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return h.next;
    }

    /**
     * 中间结点划分
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;//快慢指针,找中间链表
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;//分割成2个链表

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        //合并有序链表
        while (left != null && right != null) {
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return h.next;
    }
/******************************快排有问题待解决*******************/
    /**
     * 快排 O(nlogn) O(1)
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        quickSort(head,null);
        return head;
    }
    public void quickSort(ListNode left, ListNode right){
        if (left == right || left.next == right){
            return ;
        }
        ListNode mid = partition(left, right);
        ListNode temp = mid.next;
        mid.next = null;
        quickSort(left, mid);
        quickSort(temp, right);
    }
    public ListNode partition(ListNode left, ListNode right){
        if (left == right || left.next == right) {
            return left; //只有一个或两个元素返回第一个元素
        }
        int pivot = left.val;//选择头结点为基准点
        ListNode p1 = left, p2 = left.next;//两个移动指针

        while (p2 != p1) {
            if (p2.val < pivot){
                p1 = p1.next;
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        int tmp = p1.val;
        p1.val = pivot;
        pivot = tmp;
        return p1;
    }
/*******************************************************/
    /**
     * 链表快排 值交换
     * @param head
     * @return
     */
    public ListNode sortList3(ListNode head) {
    quickSort2(head, null);
    return head;
}

    void quickSort2(ListNode head, ListNode tail){
        if(head == tail || head.next == tail) return;
        int pivot = head.val;//首节点为基准点
        ListNode left = head, cur = head.next;//两个移动指针

        while(cur != tail){ //cur从基准点后元素开始
            if(cur.val < pivot){//当前结点值小于基准点，则移动left指针，
                // 最后left指向的位置，前面结点都是小于pivot,后面结点都大于等于pivot
                left = left.next;
                //swap(left, cur);
                int tmp = left.val;
                left.val = cur.val;
                cur.val = tmp;
            }
            cur = cur.next;//每次移动当前指针，直到末尾，
        }
        //找到基准点left结点，交换基准点的值与left的值
        //swap(head, left);
        int tmp = head.val;
        head.val = left.val;
        left.val = tmp;
        quickSort2(head, left);
        quickSort2(left.next, tail);
    }
    /*********************快排不交换值************************/
    public ListNode sortList4(ListNode head) {
        return quickSort(head);
    }
    ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int pivot = head.val;//基准点
        //链表划分
        ListNode lh = new ListNode(-1), rh = new ListNode(-1);
        ListNode l = lh, r = rh, cur = head;

        while (cur !=null) {
            if (cur.val < pivot) {
                l.next = cur;
                l = l.next;
            }else {
                r.next = cur;
                r = r.next;
            }
            cur = cur.next;
        }
        l.next = rh.next;
        r.next = null;

        ListNode right = quickSort(head.next);
        head.next = null;
        ListNode left = quickSort(lh.next);

        cur = left;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = right;
        return left;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(13);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(40);
        ListNode e = new ListNode(14);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        ListNode res = (new Solution()).sortList4(a);
        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.print("null");
    }

}
