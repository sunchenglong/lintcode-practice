package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/9.
 */
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = l1;
        int c = 0;
        ListNode p = l1;
        ListNode q = l2;
        int tmp = 0;
        int result;
        while (true) {
            if (q != null) {
                tmp = q.val;
                q = q.next;
            } else {
                tmp = 0;
            }
            result = p.val + tmp + c;
            p.val = result % 10;
            c = result / 10;
            if (p.next != null) {
                p = p.next;
            } else {
                break;
            }
        }
        if (c == 0) {
            if (q == null) return dumpy.next;
            else p.next = q;
        } else {
            if (q == null) p.next = new ListNode(c);
            else {
                p.next = q;
                while (true) {
                    result = q.val + c;
                    q.val = result % 10;
                    c = result / 10;
                    if (q.next != null) q = q.next;
                    else break;
                }
                if (c != 0) {
                    q.next = new ListNode(c);
                }
            }
        }
        return dumpy.next;
    }
}
