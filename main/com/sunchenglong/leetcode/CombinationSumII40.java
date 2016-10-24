package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/24.
 */
public class CombinationSumII40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combSum_recursion(0, target, candidates, list, result);
        return result;
    }

    void combSum_recursion(int index, int target, int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        } else if (target > 0) {
            int length = nums.length;
            for (int i = index; i < length; i++) {
                list.add(nums[i]);
                combSum_recursion(i + 1, target - nums[i], nums, list, res);
                list.remove(list.size() - 1);
                while (i < length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
    }
}
