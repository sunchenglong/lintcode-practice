package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/9/28.
 */
public class PerfectSquares279 {
    public int numSquares(int n) {
        int c[] = new int[n + 1];
        c[0] = 0;
        if (isSquare(n)) return 1;
        for (int i = 1; i <= n; i++) {
            int result = Integer.MAX_VALUE;
            int tmp;
            if (isSquare(i)) {
                c[i] = 1;
            } else {
                for (int j = 1; j < i / 2 + 1; j++) {
                    tmp = c[j] + c[i - j];
                    result = result < tmp ? result : tmp;
                }
                c[i] = result;
            }
        }
        return c[n];
    }

    public boolean isSquare(int n) {
        return (Math.sqrt(n) - (int) Math.sqrt(n)) < 0.00000001;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares279().isSquare(9));
        System.out.println(new PerfectSquares279().numSquares(12));
    }
}
