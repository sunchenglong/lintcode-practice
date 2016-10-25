package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/25.
 */
public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            sArr[s.charAt(i) - 'a'] += 1;
            tArr[t.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < 26;i++){
            if(sArr[i] != tArr[i])
                return false;
        }
        return true;
    }
}
