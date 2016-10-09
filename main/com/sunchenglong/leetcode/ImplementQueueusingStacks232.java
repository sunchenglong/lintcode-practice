package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class ImplementQueueusingStacks232 {
}

class MyQueue {
    private List<Integer> stack = null;

    private int head = 0;
    private int tail = 0;

    public MyQueue() {
        stack = new ArrayList<Integer>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        stack.add(x);
        tail++;
    }

    // Removes the element from in front of queue.
    public void pop() {
        head++;
    }

    // Get the front element.
    public int peek() {
        return stack.get(head);
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return head == tail;
    }
}
