package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/8/8.
 */
public class ReverseLinkedList206 {
    //递归求解
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rest = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    /* 头插法
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode p = head.next;
        while (p != null) {
            head.next = p.next;
            p.next = dumpy.next;
            dumpy.next = p;
            p = head.next;
        }
        return dumpy.next;
    }
*/
    public static void main(String[] args) {

    }
}
