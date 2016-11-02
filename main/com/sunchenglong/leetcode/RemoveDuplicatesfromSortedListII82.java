package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/11/2.
 */
public class RemoveDuplicatesfromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode prev = dumpy;
        ListNode cur = dumpy.next;
        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (prev.next == cur) {
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        return dumpy.next;
    }
}
