package com.sunchenglong.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenglong Sun on 2016/10/29.
 */
public class NQueensII52 {

    public int totalNQueens(int n) {
        List<Integer> taken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            taken.add(i, -1);
        }
        return getNQueens(taken, 0, n);
    }

    private int getNQueens(List<Integer> taken, int level, int n) {
        if (level == n) {
            return 1;
        } else {
            int ways = 0;
            for (int i = 0; i < n; i++) {
                if (isValid(taken, level, i)) {
                    taken.set(level, i);
                    ways += getNQueens(taken, level + 1, n);
                    taken.set(level, -1);
                }
            }
            return ways;
        }
    }

    private boolean isValid(List<Integer> taken, int level, int index) {
        for (int i = 0; i < level; i++) {
            if (taken.contains(index) || taken.get(i) + i == level + index || taken.get(i) + level == i + index) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII52().totalNQueens(4));
    }
}
