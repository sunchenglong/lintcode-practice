package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/30.
 */
public class CombinationSumIII216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsSolver(result, path, 1, n, 10, 0, k);
        return result;
    }

    private void dfsSolver(List<List<Integer>> result, List<Integer> path, int index, int target, int n, int level, int k) {
        if (target == 0 && level == k) {
            result.add(new ArrayList<>(path));
        } else if (target > 0 && level < k) {
            for (int i = index; i < n; i++) {
                if (target - i >= 0) {
                    path.add(i);
                    dfsSolver(result, path, i + 1, target - i, n, level + 1, k);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIII216().combinationSum3(3, 7));
    }
}
