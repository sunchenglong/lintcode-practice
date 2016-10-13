package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/13.
 */
public class SwapNodesinPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode listNode = swapPairs(head.next.next);
        ListNode ret = head.next;
        head.next.next = head;
        head.next = listNode;
        return ret;
    }
}
