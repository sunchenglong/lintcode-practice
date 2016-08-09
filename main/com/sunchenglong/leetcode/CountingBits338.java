package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/9.
 */
//Todo Wrong answer
public class CountingBits338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i == 0) result[i] = 0;
            else if (isPowerOfTwo(i)) result[i] = 1;
            else if (i % 2 == 1) result[i] = result[i - 1] + 1;
            else result[i] = result[i - 1];
        }
        return result;
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        return Integer.toBinaryString(n).matches("^1(0)*");
    }

    public static void main(String[] args) {
        System.out.println(new CountingBits338().countBits(2));
    }
}
