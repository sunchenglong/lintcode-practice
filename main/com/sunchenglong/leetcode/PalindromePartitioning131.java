package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/27.
 */
public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, path, result);
        return result;
    }

    private void dfs(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = start + 1; i <= s.length(); i++) {
                if (isPalindrome(s.substring(start, i))) {
                    path.add(s.substring(start, i));
                    dfs(s, i, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int length = s.length();
        if (length < 1) return false;
        if (length == 1) return true;
        int i, j;
        for (i = 0, j = length - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning131().isPalindrome("abcaa"));
        String s = "abacdeea";
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        s = String.valueOf(tmp);
        System.out.println(s);
    }
}
