package com.sunchenglong.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chenglong Sun on 2016/10/25.
 */
public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        Set<Character> status = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (status.contains(c)) {
                status.remove(c);
            } else {
                status.add(c);
            }
        }
        return s.length() - (status.size() == 0 ? 0 : status.size() - 1);
    }
}
