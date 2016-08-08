package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/8.
 */
public class ReverseLinkedList206 {
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

    public static void main(String[] args) {

    }
}
