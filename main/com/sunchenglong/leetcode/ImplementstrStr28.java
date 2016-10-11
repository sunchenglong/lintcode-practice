package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/12.
 */
public class ImplementstrStr28 {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.equals("")) return 0;
        int length1 = haystack.length();
        int length2 = needle.length();
        int j;
        for (int i = 0; i < length1 && i <= length1 - length2; i++) {
            for (j = 0; j < length2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
            }
            if (j == length2 && haystack.charAt(i + j - 1) == needle.charAt(j - 1)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementstrStr28().strStr("mississippi", "issipi"));
    }
}
