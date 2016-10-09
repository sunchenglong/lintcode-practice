package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class ImplementStackusingQueues225 {
}

class MyStack {
    private List<Integer> queue = null;

    private int head = 0;
    private int tail = 0;

    public MyStack() {
        queue = new ArrayList<Integer>();
    }

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        tail++;
    }

    // Removes the element on top of the stack.
    public void pop() {
        tail --;
        queue.remove(tail);
    }

    // Get the top element.
    public int top() {
        return queue.get(tail-1);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return head == tail;
    }
}