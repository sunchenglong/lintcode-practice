package com.sunchenglong.leetcode;

import java.util.Stack;

/**
 * Created by Administrator on 2016/11/1.
 */
public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens == null || tokens.length < 1) return 0;
        int i = 0, result = 0;
        while (i < tokens.length) {
            if (tokens[i].matches("-?\\d{1,}")) {
                stack.push(Integer.valueOf(tokens[i++]));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (tokens[i++]) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println("1123".matches("-?\\d{1,}"));
    }
}
