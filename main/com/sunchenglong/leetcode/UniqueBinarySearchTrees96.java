package com.sunchenglong.leetcode;

/**
 * Created by Chenlong Sun on 2016/10/21.
 */
public class UniqueBinarySearchTrees96 {
    public int numTrees(int n) {
        if (n < 0) return 0;
        if (n <= 1) return 1;
        int f[] = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            int result = 0;
            for (int j = 0; j < i; j++) {
                result += f[j] * f[i - j - 1];
            }
            f[i] = result;
        }
        return f[n];
    }
}
