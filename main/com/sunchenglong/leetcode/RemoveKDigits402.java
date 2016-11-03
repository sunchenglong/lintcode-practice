package com.sunchenglong.leetcode;

import java.util.Stack;

/**
 * Created by suncl on 2016/11/3.
 */
public class RemoveKDigits402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int length = num.length();
        int pos = 0;
        k = length - k;
        for (int i = 0; i < length; i++) {
            if (i <= length - k) {
                if (num.charAt(pos) > num.charAt(i)) {
                    pos = i;
                }
            }
            if (i == length - k) {
                if (stringBuilder.length() != 0 || num.charAt(pos) != '0') {
                    stringBuilder.append(num.charAt(pos));
                }
                i = pos;
                pos++;
                k--;
            }
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits402().removeKdigits("1432219", 3));
    }
}
