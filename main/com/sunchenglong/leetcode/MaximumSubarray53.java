package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/14.
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int f = 0;
        for (int num : nums) {
            f = Math.max(f + num, num);
            result = Math.max(result, f);
        }
        return result;
    }
}
