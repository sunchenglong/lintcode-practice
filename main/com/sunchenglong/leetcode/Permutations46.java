package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/26.
 */
public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, path, result);
        return result;
    }

    public void dfs(int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!path.contains(nums[i])) {
                    path.add(nums[i]);
                    dfs(nums, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
