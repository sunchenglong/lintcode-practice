package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/8.
 */
public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows < 1) return result;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(1);
        result.add(tmp);
        int left, right;
        for (int i = 1; i < numRows; i++) {
            tmp = new ArrayList<Integer>();
            for (int j = -1; j < i; j++) {
                if (j == -1) tmp.add(1);
                else if (j == i - 1) tmp.add(1);
                else {
                    tmp.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
                }
            }
            result.add(tmp);
        }
        return result;
    }
}
