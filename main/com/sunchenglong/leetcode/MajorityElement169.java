package com.sunchenglong.leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/10/18.
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
