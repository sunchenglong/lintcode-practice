package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/17.
 */
public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] f = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++)
            f[i][0] = i;
        for (int i = 0; i <= length2; i++)
            f[0][i] = i;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    f[i][j] = f[i - 1][j - 1];
                else {
                    int tmp = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.min(f[i - 1][j - 1] + 1, tmp + 1);
                }
            }
        }
        return f[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance72().minDistance("ab", "bc"));
    }
}
