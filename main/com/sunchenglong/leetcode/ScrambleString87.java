package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */
public class ScrambleString87 {
    public boolean isScramble(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 != length2) return false;
        int length = length1;
        boolean[][][] f = new boolean[length + 1][length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                f[1][i][j] = (s1.charAt(i) == s2.charAt(j));
        }
        for (int n = 1; n <= length; n++) {
            for (int i = 0; i + n <= length; i++) {
                for (int j = 0; j + n <= length; j++) {
                    for (int k = 1; k < n; k++) {
                        if ((f[k][i][j] && f[n - k][i + k][j + k]) || (f[k][i][j + n - k] && f[n - k][i + k][j])) {
                            f[n][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[length][0][0];
    }

    public static void main(String[] args) {
        System.out.println(new ScrambleString87().isScramble("aa", "aa"));
    }
}
