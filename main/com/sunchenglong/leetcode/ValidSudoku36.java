package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/9.
 */
public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] sq = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = board[i][j] - '1';
                if (value >= 0 && value < 9) {
                    if (row[value][i] || col[value][j] || sq[i/3][j/3][value])
                        return false;
                    row[value][i] = true;
                    col[value][j] = true;
                    sq[i/3][j/3][value] =true;
                }
            }
        }
        return true;
    }
}
