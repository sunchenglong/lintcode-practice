package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/30.
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsCombine(result, path, target, candidates, 0);
        return result;
    }

    public void dfsCombine(List<List<Integer>> result, List<Integer> path, int target, int[] candidates, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = 0; i < candidates.length; i++) {
                if (target - candidates[i] >= 0 && i >= index) {
                    path.add(candidates[i]);
                    dfsCombine(result, path, target - candidates[i], candidates, i);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

}
