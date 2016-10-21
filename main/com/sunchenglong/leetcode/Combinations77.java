package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/21.
 */
public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combRecursion(n, k, 1, result, list);
        return result;
    }

    private void combRecursion(int n, int k, int start, List<List<Integer>> res, List<Integer> list) {
        if (k != 0) {
            for (int i = start; i <= n; i++) {
                list.add(i);
                combRecursion(n, k - 1, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        } else {
            List<Integer> tmp = new ArrayList<>(list);
            res.add(tmp);
        }
    }
}
