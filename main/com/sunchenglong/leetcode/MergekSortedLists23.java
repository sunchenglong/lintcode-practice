package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKList(lists, 0, lists.length);
    }

    ListNode mergeKList(ListNode[] lists, int start, int end) {
        if (end - start == 2) {
            return mergeTwoLists(lists[start], lists[start + 1]);
        } else if (end - start == 1) {
            return lists[start];
        } else {
            int media = start + (end - start) / 2;
            return mergeTwoLists(mergeKList(lists, start, media), mergeKList(lists, media, end));
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode prev = ans;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        return ans.next;
    }
}
