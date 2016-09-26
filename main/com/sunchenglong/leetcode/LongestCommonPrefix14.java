package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/26.
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        String commonStr = strs[0];
        for (String str : strs) {
            commonStr = longestCommonPrefix(str, commonStr);
        }
        return commonStr;
    }

    public String longestCommonPrefix(String a, String b) {
        if(a.length() == 0 || b.length() ==0) return "";
        int length = a.length() > b.length() ? b.length() : a.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) break;
            count++;
        }
        if (a.charAt(0) != b.charAt(0)) return "";
        return a.substring(0, count);
    }

    public static void main(String[] args) {
        LongestCommonPrefix14 longestCommonPrefix14 = new LongestCommonPrefix14();
        System.out.println(longestCommonPrefix14.longestCommonPrefix("abffkjdla", "aceldjfs"));
    }
}
