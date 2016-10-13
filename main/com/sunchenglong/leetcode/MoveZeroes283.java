package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/13.
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[++index] = nums[i];
                if (index < i) nums[i] = 0;
            }
        }
    }
}
