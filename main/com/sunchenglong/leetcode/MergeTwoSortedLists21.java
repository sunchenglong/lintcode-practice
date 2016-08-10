package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/10.
 */
public class MergeTwoSortedLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode prev = ans;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 == null)
            prev.next = l2;
        if(l2 == null)
            prev.next = l1;
        return ans.next;
    }
}
