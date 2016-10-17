package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */
public class InterleavingString97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length3 != length1 + length2) return false;
        boolean[][] f = new boolean[length1 + 1][length2 + 1];
        f[0][0] = true;
        for (int i = 1; i <= length1; i++) {
            f[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1) && f[i - 1][0]);
        }
        for (int j = 1; j <= length2; j++) {
            f[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1) && f[0][j - 1]);
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                f[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && f[i - 1][j]) ||
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1) && f[i][j - 1]);
            }
        }
        return f[length1][length2];
    }
}
