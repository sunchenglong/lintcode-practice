package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/13.
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        int length = nums.length;
        int[] c = new int[length];
        if (length <= 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        c[0] = nums[0];
        c[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            c[i] = Math.max(c[i - 1], c[i - 2] + nums[i]);
        }
        return c[length - 1];
    }
}
