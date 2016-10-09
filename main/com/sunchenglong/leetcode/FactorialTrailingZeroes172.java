package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class FactorialTrailingZeroes172 {
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        System.out.println(Long.numberOfTrailingZeros(64));
        System.out.println(64 >> Long.numberOfTrailingZeros(64));
        System.out.println(new FactorialTrailingZeroes172().trailingZeroes(4));
    }
}
