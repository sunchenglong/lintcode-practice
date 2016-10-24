package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/24.
 */
public class SubsetsII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            combRecursion(0, i, nums, list, result);
        }
        return result;
    }

    private void combRecursion(int start, int end, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (end == 0) {
            result.add(new ArrayList<>(list));
        } else if (end > 0) {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                combRecursion(i + 1, end - 1, nums, list, result);
                list.remove(list.size() - 1);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
    }
}
