package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        s = s.toLowerCase().replaceAll("\\W", "");
        int right = s.length() - 1;
        if (right - left <= 0) return true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("ABcf".toUpperCase());
    }
}

