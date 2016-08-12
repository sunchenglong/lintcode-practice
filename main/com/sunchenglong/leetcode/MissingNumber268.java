package com.sunchenglong.leetcode;

/**
 * Created by Administrator on 2016/8/10.
 */
public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sum = n * (n - 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
