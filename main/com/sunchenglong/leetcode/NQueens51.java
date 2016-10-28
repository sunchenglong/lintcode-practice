package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/29.
 */
public class NQueens51 {
    public List<List<String>> solveNQueens(int n) {
        List<Integer> taken = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            taken.add(i, -1);
        }
        getNQueens(result, 0, n, taken);
        return result;
    }

    private void getNQueens(List<List<String>> result, int level, int n, List<Integer> taken) {
        if (level == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    s.append(".");
                }
                s.setCharAt(taken.get(i), 'Q');
                board.add(s.toString());
            }
            result.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (isValid(taken, level, n, i)) {
                    taken.set(level, i);
                    getNQueens(result, level + 1, n, taken);
                    taken.set(level, -1);
                }
            }
        }
    }

    private boolean isValid(List<Integer> taken, int level, int n, int index) {
        for (int i = 0; i < level; i++) {
            if (taken.contains(index) || taken.get(i) + i == level + index || taken.get(i) + level == i + index) {
                return false;
            }
        }
        return true;
    }

}
