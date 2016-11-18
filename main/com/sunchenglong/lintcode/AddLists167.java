package com.sunchenglong.lintcode;

/**
 * Created by suncl on 2016/11/18.
 */
public class AddLists167 {
    public ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode p = result;
        while (carry != 0 || l1 != null || l2 != null) {
            int val1 = (l1 == null ? 0 : l1.val);
            int val2 = (l2 == null ? 0 : l2.val);
            int val = val1 + val2 + carry;
            p.next = new ListNode(val % 10);
            carry = val / 10;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
            p = p.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        System.out.println(new AddLists167().addLists(new ListNode(3), new ListNode(4)));
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}