package com.sunchenglong.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/8/25.
 */
public class RemoveNthNodeFromEndofList19 {
    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (n <= 0 || head == null) return head;
            ListNode dumpy = new ListNode(-1);
            dumpy.next = head;
            ListNode p = head;
            ListNode q = head;
            while (n != 1) {
                if(q.next == null){
                    return dumpy.next;
                }
                q = q.next;
                n --;
            }
            ListNode pre = new ListNode(-1);
            pre = dumpy;
            while(q.next != null) {
                pre = pre.next;
                p = p.next;
                q = q.next;
            }
            pre.next = p.next;
            return dumpy.next;
        }
    }
}

