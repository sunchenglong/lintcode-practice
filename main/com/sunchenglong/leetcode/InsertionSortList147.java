package com.sunchenglong.leetcode;

import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dumpy = new ListNode(-1);
        while (head != null) {
            ListNode p = dumpy;
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            ListNode tmp = new ListNode(head.val);
            tmp.next = p.next;
            p.next = tmp;
            head = head.next;
        }
        return dumpy.next;
    }
}
