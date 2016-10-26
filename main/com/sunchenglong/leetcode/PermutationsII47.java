package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, path, result);
        return result;
    }

    private void dfs(int[] nums, boolean used[], List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i == 0 || nums[i] != nums[i - 1] || used[i - 1]) {
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(nums, used, path, result);
                    path.remove(path.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
