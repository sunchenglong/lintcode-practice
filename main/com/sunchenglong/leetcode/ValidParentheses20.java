package com.sunchenglong.leetcode;

import java.util.Stack;

/**
 * Created by Chenglong Sun on 2016/10/18.
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        String left = "({[";
        String right = ")}]";
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        if (length <= 0) return true;
        if (length % 2 == 1) return false;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (left.indexOf(c) > -1) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    if (left.indexOf(stack.peek()) == right.indexOf(c)) {
                        stack.pop();
                    } else return false;
                } else return false;
            }
        }
        return stack.isEmpty();
    }
}
