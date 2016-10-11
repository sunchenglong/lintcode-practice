package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/11.
 */
public class ReverseBits190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 31; i >= 0; i--, n >>= 1) {
            result |= ((n & 1) << i);
        }
        return result;
    }
}
