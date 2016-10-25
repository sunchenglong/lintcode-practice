package com.sunchenglong.leetcode;

/**
 * Created by Chenglong Sun on 2016/10/24.
 */
public class SurroundedRegions130 {

    public void solve(char[][] board) {
        if (board.length <= 0) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[board.length - 1][j] == 'O') {
                dfs(board, board.length - 1, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i - 1 > 0 && board[i - 1][j] == 'O') {
                dfs(board, i - 1, j);
            }
            if (i + 1 < board.length && board[i + 1][j] == 'O') {
                dfs(board, i + 1, j);
            }
            if (j - 1 > 0 && board[i][j - 1] == 'O') {
                dfs(board, i, j - 1);
            }
            if (j + 1 < board[0].length && board[i][j + 1] == 'O') {
                dfs(board, i, j + 1);
            }
        }
    }
}
