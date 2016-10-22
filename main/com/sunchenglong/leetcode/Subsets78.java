package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int max = 1 << nums.length;
        for (int i = 0; i < max; i++) {
            int tmp = i;
            int index = 0;
            List<Integer> subArray = new ArrayList<>();
            while (tmp != 0) {
                if ((tmp & 1) == 1)
                    subArray.add(nums[index]);
                tmp = tmp >> 1;
                index++;
            }
            result.add(subArray);
        }
        return result;
    }
}

