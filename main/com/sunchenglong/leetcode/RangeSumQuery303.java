package com.sunchenglong.leetcode;

import java.util.Arrays;

/**
 * Created by Chenglong Sun on 2016/10/12.
 */
public class RangeSumQuery303 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
    }
}

class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        int length = nums.length;
        if (length > 0) {
            sums = new int[length + 1];
            sums[0] = 0;
            for (int i = 0; i < length; i++) {
                sums[i + 1] = nums[i] + sums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}