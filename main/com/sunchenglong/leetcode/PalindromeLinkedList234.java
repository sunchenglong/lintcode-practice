package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode fast = dumpy;
        ListNode slow = dumpy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = reverse(slow.next);
        while (p != null) {
            if (head.val != p.val) return false;
            head = head.next;
            p = p.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
