package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class ConvertSortedList109 {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode start, ListNode end) {
        if (start == end) return null;
        ListNode mid = start;
        ListNode fast = start;
        while (fast.next != end && fast.next.next != end) {
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode res = new TreeNode(mid.val);
        res.left = sortedListToBST(start, mid);
        res.right = sortedListToBST(mid.next, end);
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-1);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4 = null;
        ConvertSortedList109 convertSortedList109 = new ConvertSortedList109();
        TreeNode treeNode = convertSortedList109.sortedListToBST(listNode1);
        System.out.println(treeNode);
    }
}
