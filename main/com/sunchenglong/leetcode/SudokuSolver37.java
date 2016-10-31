package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/31.
 */
public class SudokuSolver37 {

    private char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void solveSudoku(char[][] board) {
        if (dfsSolver(board))
            return;
    }

    private boolean dfsSolver(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; i < 10; i++) {
                        board[i][j] = table[k];
                        if (isValidSudoku(board)) {
                            if (dfsSolver(board)) {
                                return true;
                            }
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] sq = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value = board[i][j] - '1';
                if (value >= 0 && value < 9) {
                    if (row[value][i] || col[value][j] || sq[i / 3][j / 3][value])
                        return false;
                    row[value][i] = true;
                    col[value][j] = true;
                    sq[i / 3][j / 3][value] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('1');
    }
}
