package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/18.
 */
public class DeleteNodeinaLinkedList237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
