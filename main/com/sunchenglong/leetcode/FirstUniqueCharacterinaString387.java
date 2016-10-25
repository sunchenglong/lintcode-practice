package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/25.
 */
public class FirstUniqueCharacterinaString387 {
    public int firstUniqChar(String s) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a'] += 1;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (table[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
