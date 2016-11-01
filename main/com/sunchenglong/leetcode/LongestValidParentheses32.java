package com.sunchenglong.leetcode;

import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        int maxLenth = 0, last = -1;
        Stack<Integer> lefts = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    last = i;
                } else {
                    lefts.pop();
                    if (lefts.isEmpty()) {
                        maxLenth = Math.max(maxLenth, i - last);
                    } else {
                        maxLenth = Math.max(maxLenth, i - lefts.peek());
                    }
                }
            }
        }
        return maxLenth;
    }
}
