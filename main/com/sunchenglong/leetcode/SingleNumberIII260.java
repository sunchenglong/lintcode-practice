package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/24.
 */
public class SingleNumberIII260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] results = new int[]{0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                results[0] ^= num;
            } else {
                results[1] ^= num;
            }
        }
        return results;
    }
}
