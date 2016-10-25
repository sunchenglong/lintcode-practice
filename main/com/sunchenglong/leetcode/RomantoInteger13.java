package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/25.
 */
public class RomantoInteger13 {
    public int romanToInt(String s) {
        int sum = transfer(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (transfer(s.charAt(i + 1)) > transfer(s.charAt(i))) {
                sum -= transfer(s.charAt(i));
            } else {
                sum += transfer(s.charAt(i));
            }
        }
        return sum;
    }

    public int transfer(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
