package com.sunchenglong.leetcode;

import com.sunchenglong.thread.thinking.ListOff;

/**
 * Created by Administrator on 2016/8/6.
 */
public class RemoveLinkedListElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = head;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode q = dumpy;
        while (p != null) {
            if (p.val == val) {
                q.next = p.next;
            } else {
                q = q.next;
            }
            p = p.next;
        }
        return dumpy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}