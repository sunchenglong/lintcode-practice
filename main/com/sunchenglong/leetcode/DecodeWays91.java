package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */
public class DecodeWays91 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;

        int length = s.length();
        int prev = 0;
        int cur = 1;

        for (int i = 1; i <= length; i++) {
            if (s.charAt(i - 1) == '0') cur = 0;
            if (i < 2 || !((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))) {
                prev = 0;
            }
            int tmp = cur;
            cur = prev + cur;
            prev = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays91().numDecodings("27"));
    }
}
