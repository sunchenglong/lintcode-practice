package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */
public class DistinctSubsequences115 {
    public int numDistinct(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (length1 <= 0 || length1 < length2) return 0;
        if (length2 <= 0) return length1;
        int[][] f = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s.charAt(i-1) != t.charAt(j-1)) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                }
            }
        }
        return f[length1][length2];
    }
}
