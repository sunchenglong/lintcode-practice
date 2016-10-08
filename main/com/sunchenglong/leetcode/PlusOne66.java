package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/8.
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (length == 0) return new int[]{1};
        int tmp = 0;
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            tmp = digits[i];
            digits[i] = (tmp + carry) % 10;
            carry = (tmp + carry) / 10;
        }
        if (carry == 0) return digits;
        else {
            int result[] = new int[length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        }
    }
}
