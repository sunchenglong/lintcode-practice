package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast = fast.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dumpy.next;
    }
}
