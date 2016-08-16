package com.sunchenglong.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chenglong Sun on 2016/8/16.
 */
public class CopyListwithRandomPointer138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> randomMap = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode result = new RandomListNode(0);
        result.next = head;
        RandomListNode h1 = result;
        RandomListNode p1 = head;
        while (p1 != null) {
            h1.next = new RandomListNode(p1.label);
            randomMap.put(p1, h1.next);
            h1 = h1.next;
            p1 = p1.next;
        }
        RandomListNode h2 = result.next;
        RandomListNode p2 = head;
        while (p2 != null) {
            h2.random = randomMap.get(p2.random);
            h2 = h2.next;
            p2 = p2.next;
        }
        return result.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};
