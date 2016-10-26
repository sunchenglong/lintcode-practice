package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            if (head.val > head.next.val) {
                int tmp = head.val;
                head.val = head.next.val;
                head.next.val = tmp;
                return head;
            }
        }
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode slow = dumpy, fast = dumpy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        return mergeSort(left, right);
    }

    ListNode mergeSort(ListNode p, ListNode q) {
        ListNode prev = new ListNode(-1);
        ListNode result = prev;
        while (p != null || q != null) {
            int val1 = p == null ? Integer.MAX_VALUE : p.val;
            int val2 = q == null ? Integer.MAX_VALUE : q.val;
            if (val1 < val2) {
                result.next = p;
                p = p.next;
            } else {
                result.next = q;
                q = q.next;
            }
            result = result.next;
        }
        return prev.next;
    }
}
