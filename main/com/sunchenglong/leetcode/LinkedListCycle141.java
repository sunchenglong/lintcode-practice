package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
