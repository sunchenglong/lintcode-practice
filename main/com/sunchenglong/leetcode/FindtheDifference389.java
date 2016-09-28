package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class FindtheDifference389 {
    public char findTheDifference(String s, String t) {
        int length = t.length();
        int result = 0;
        for (int i = 0; i < length - 1; i++) {
            result ^= s.charAt(i) - 'a';
            result ^= t.charAt(i) - 'a';
        }
        result ^= t.charAt(length - 1) - 'a';
        return (char) ((int) 'a' + result);
    }

    public static void main(String[] args) {

    }
}
