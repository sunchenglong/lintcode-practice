package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/13.
 */
public class PowerofThree326 {
    public boolean isPowerOfThree(int n) {
        return (n > 0 && Math.pow(3, 19) % n == 0);
    }
}
