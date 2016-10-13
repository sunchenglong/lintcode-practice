package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/13.
 */
public class ThirdMaximumNumber414 {
    public int thirdMax(int[] nums) {
        int length = nums.length;
        if (length < 1) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        int max = Integer.MIN_VALUE;
        int oldMax = Integer.MAX_VALUE;
        int n = 3;
        while (n-- > 0) {
            max = Integer.MIN_VALUE;
            for (int num : nums) {
                if (num < oldMax) {
                    max = max > num ? max : num;
                }
            }
            oldMax = max;
        }
        return max;
    }
}
