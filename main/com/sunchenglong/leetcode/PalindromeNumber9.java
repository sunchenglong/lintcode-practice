package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x < 100) return x % 11 == 0;
        if (x % 10 == 0) return false;
        int v = x % 10;
        x = x / 10;
        while (x - v > 0) {
            v = v * 10 + x % 10;
            x /= 10;
        }
        if (v > x) v /= 10;
        return x == v;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome(100));
    }
}
